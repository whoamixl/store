package com.cy.store.service.ex;

/**
 * @ClassName AddressCountLimitException
 * @Description 收货地址超出20条的异常
 * @Author Yxl
 * @Date 2022/1/24 22:55
 * @Version 1.0
 **/
public class AddressCountLimitException extends ServiceException{
    public AddressCountLimitException() {
        super();
    }

    public AddressCountLimitException(String message) {
        super(message);
    }

    public AddressCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCountLimitException(Throwable cause) {
        super(cause);
    }

    protected AddressCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
