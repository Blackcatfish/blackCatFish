package com.blackfish.shiro.exception;


import com.blackfish.shiro.enums.ErrorEnum;
import com.blackfish.shiro.enums.ExceptionEnum;


public class CustomizeException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    protected String code;


    protected String message;//打印出的日志信息

    public CustomizeException(ExceptionEnum enums, String message) {
        super();
        this.code = enums.getCode();
        this.message = enums.getMsg();
    }

    public CustomizeException(ExceptionEnum enums) {
        super();
        this.code = enums.getCode();
        this.message = enums.getMsg();
    }

    public CustomizeException(ErrorEnum enums) {
        super();
        this.code = enums.getCode();
    }

    public CustomizeException(String code, String msg) {

        this.code = code;
        this.message = msg;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public CustomizeException() {
        super();
    }

    public CustomizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomizeException(String message) {
        super(message);
    }


}
