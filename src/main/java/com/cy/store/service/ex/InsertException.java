package com.cy.store.service.ex;

/**
 * @ClassName InsertException
 * @Description 数据在插入过程中产生的异常
 * @Author Yxl
 * @Date 2022/1/20 21:46
 * @Version 1.0
 **/
public class InsertException extends ServiceException{
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
