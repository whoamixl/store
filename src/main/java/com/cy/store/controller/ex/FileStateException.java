package com.cy.store.controller.ex;

/**
 * @ClassName FileStateException
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/23 10:43
 * @Version 1.0
 **/
public class FileStateException extends FileUploadException{
    public FileStateException() {
        super();
    }

    public FileStateException(String message) {
        super(message);
    }

    public FileStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileStateException(Throwable cause) {
        super(cause);
    }

    protected FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
