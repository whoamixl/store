package com.cy.store.service;

import com.cy.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName AddressServiceTests
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/24 23:16
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {

    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddress(){
        Address address = new Address();
        address.setAddress("asdasd");

        addressService.addNewAddress(14,"t1",address);

    }

}
