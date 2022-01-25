package com.cy.store.controller.ex;

/**
 * @ClassName FileEmptyException
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/23 10:39
 * @Version 1.0
 **/
public class FileEmptyException extends FileUploadException{
    public FileEmptyException() {
        super();
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    protected FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
