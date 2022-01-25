package com.cy.store.service.ex;

/**
 * @ClassName PasswordNotMatchException
 * @Description 密码不匹配异常类
 * @Author Yxl
 * @Date 2022/1/21 21:44
 * @Version 1.0
 **/
public class PasswordNotMatchException extends ServiceException{
    public PasswordNotMatchException() {
        super();
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    protected PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
