package com.cy.store.service.ex;

/**
 * @ClassName UsernameNotFoundException
 * @Description 用户未找到的异常类
 * @Author Yxl
 * @Date 2022/1/21 21:44
 * @Version 1.0
 **/
public class UsernameNotFoundException extends ServiceException{

    public UsernameNotFoundException() {
        super();
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }

    public UsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UsernameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
