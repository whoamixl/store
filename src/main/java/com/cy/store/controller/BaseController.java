package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * @ClassName BaseController
 * @Description 表示控制层的基类
 * @Author Yxl
 * @Date 2022/1/20 23:04
 * @Version 1.0
 **/
public class BaseController {

    /**
      *操作成功状态码
      */
    public static final int OK = 200;

    /**
     * @Description:请求处理方法
     *              自动将异常对象传递给参数的列表上,当项目中参审的异常，被统一拦截到这个方法，统一处理完给前端
     * @Author: xiaolong
     * @Date: 2022/1/20 23:06
     * @param:
     * @return: null
     **/
    @ExceptionHandler({ServiceException.class,FileUploadException.class}) //统一处理抛出的异常
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        }
        if(e instanceof UsernameNotFoundException){
            result.setState(4001);
            result.setMessage("用户数据不存在");
        }
        if(e instanceof PasswordNotMatchException){
            result.setState(4002);
            result.setMessage("用户密码错误");
        }
        if(e instanceof AddressCountLimitException){
            result.setState(4003);
            result.setMessage(e.getMessage());
        }
        if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生的未知异常");
        }
        if(e instanceof UpdateException){
            result.setState(5001);
            result.setMessage("更新数据时产生的异常");
        }
        if (e instanceof FileEmptyException){
            result.setState(6000);
        }
        if (e instanceof FileSizeException){
            result.setState(6001);
        }
        if (e instanceof FileTypeException){
            result.setState(6002);
        }
        if (e instanceof FileStateException){
            result.setState(6003);
        }
        if (e instanceof FileUploadIOException){
            result.setState(6004);
        }
        return result;
    }

    /**
     * @Description: 获取session uid
     * @Author: xiaolong
     * @Date: 2022/1/21 22:46
     * @param session: session对象
     * @return: java.lang.Integer 当前用户的uid
     **/
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * @Description:获取session username
     * @Author: xiaolong
     * @Date: 2022/1/21 22:49
     * @param session: session对象
     * @return: java.lang.String 当前用户的username
     **/
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
