package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.service.IAddressService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName AddressController
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/24 23:23
 * @Version 1.0
 **/
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController{

    @Autowired
    private IAddressService addressService;

    @PostMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        Integer uidFromSession = getUidFromSession(session);
        String usernameFromSession = getUsernameFromSession(session);
        addressService.addNewAddress(uidFromSession,usernameFromSession,address);
        return new JsonResult<>(OK,"添加成功");
    }

    @RequestMapping("list")
    public JsonResult<List<Address>> addressList(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<Address> listByUid = addressService.findListByUid(uid);
        return new JsonResult<>(OK,"获取成功",listByUid);
    }
}
