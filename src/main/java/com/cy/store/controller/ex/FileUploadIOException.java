package com.cy.store.controller.ex;

/**
 * @ClassName FileUploadIOException
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/23 10:42
 * @Version 1.0
 **/
public class FileUploadIOException extends FileUploadException{
    public FileUploadIOException() {
        super();
    }

    public FileUploadIOException(String message) {
        super(message);
    }

    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    protected FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
