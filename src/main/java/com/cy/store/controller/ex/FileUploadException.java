package com.cy.store.controller.ex;

/**
 * @ClassName FileUploadException
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/23 10:39
 * @Version 1.0
 **/
public class FileUploadException extends RuntimeException{
    public FileUploadException() {
        super();
    }

    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadException(Throwable cause) {
        super(cause);
    }

    protected FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
