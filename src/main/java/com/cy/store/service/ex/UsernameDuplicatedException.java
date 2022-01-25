package com.cy.store.service.ex;

/**
 * @ClassName UsernameDulicatedException
 * @Description 用户名被占用异常类
 * @Author Yxl
 * @Date 2022/1/20 21:31
 * @Version 1.0
 **/
public class UsernameDuplicatedException extends ServiceException{

    public UsernameDuplicatedException() {
        super();
    }

    public UsernameDuplicatedException(String message) {
        super(message);
    }

    public UsernameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected UsernameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
