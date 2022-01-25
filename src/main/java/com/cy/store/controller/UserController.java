package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/20 22:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("users")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
//    @ResponseBody //表示此方法以json格式响应给前端
    public JsonResult<Void> reg(User user){
            userService.reg(user);
        return new JsonResult<>(OK,"注册成功");
    }
/*
    @RequestMapping("reg")
//    @ResponseBody //表示此方法以json格式响应给前端
    public JsonResult<Void> reg(User user){
        JsonResult<Void> result = new JsonResult<>();
        try {
            userService.reg(user);
            result.setState(200);
            result.setMessage("注册成功");
        } catch (UsernameDuplicatedException e) {
            result.setState(4000);
            result.setMessage("用户名被占用");
        } catch (InsertException e){
            result.setState(5000);
            result.setMessage("注册时参数未知异常");
        }
        return result;
    }
 */

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User loginUser = userService.login(username, password);
        session.setAttribute("uid",loginUser.getUid());
        session.setAttribute("username",loginUser.getUsername());
        System.out.println(getUidFromSession(session));
        System.out.println(getUsernameFromSession(session));
        return new JsonResult<User>(OK,"登录成功",loginUser);
    }

    @RequestMapping ("change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword,HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        Integer integer = userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(OK,"更新成功");
    }

    @RequestMapping ("change_info")
    public JsonResult<Void> changeInfo(User user,HttpSession session){
        user.setUid(getUidFromSession(session));
        userService.changeInfo(user);
        return new JsonResult<>(OK,"更新成功");
    }

    @RequestMapping ("get_info")
    public JsonResult<User> info(HttpSession session){
        Integer uidFromSession = getUidFromSession(session);
        User info = userService.getInfo(uidFromSession);
        return new JsonResult<>(OK,"更新成功",info);
    }


    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    public static final List<String> AVATAR_TYPE = new ArrayList<>();
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session, MultipartFile file){
        if (file.isEmpty()){
            throw new FileEmptyException("文件为空");
        }
        if (file.getSize()>AVATAR_MAX_SIZE){
            throw new FileSizeException("文件超出限制");
        }
        String contentType = file.getContentType();
        if (!AVATAR_TYPE.contains(contentType)){
            throw new FileTypeException("文件类型不支持");
        }
        String parent = session.getServletContext().getRealPath("upload");
        File dir = new File(parent);
        if (!dir.exists()){
            dir.mkdirs();//如果不存在就创建文件夹
        }
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        System.out.println("OriginalFilename"+originalFilename);
        int i = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(i);
        String fileName =
                UUID.randomUUID().toString().toUpperCase()
                + suffix;

        File dest = new File(dir,fileName);
        try {
            file.transferTo(dest); //写入另一个dest文件中
        }catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        } catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        }

        Integer uid = getUidFromSession(session);
        String usernameFromSession = getUsernameFromSession(session);
        String avatar = "/upload/" + fileName;
        userService.changeAvatar(uid, avatar, usernameFromSession);

        return new JsonResult<>(OK,"上传成功",avatar);

    }
}
