package com.blackfish.shiro.exception;


import com.blackfish.shiro.enums.ExceptionEnum;
import com.blackfish.shiro.vo.R;
import org.apache.ibatis.binding.BindingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.net.ConnectException;
import java.sql.SQLException;


@ControllerAdvice
@Transactional
public class CommonExceptionHandlers {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonExceptionHandlers.class);


    /**
     * 　　* @Description: 其他异常
     */
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public R exceptionGet(Exception e, HttpServletRequest request) {

        if (e instanceof NoHandlerFoundException) {
            //404
            return R.error(ExceptionEnum.NOT_FOUND.getMsg());
        } else if (e instanceof SQLException || e instanceof DataAccessException) {
            //数据库异常
            return R.error(ExceptionEnum.DATABASE_ERROR.getMsg());
        } else if (e instanceof ConnectException) {
            //网络连接异常
            return R.error(ExceptionEnum.CONNECTION_ERROR.getMsg());
        } else if (e instanceof BindException) {
            //请求参数类型错误异常的捕获
            return R.error(ExceptionEnum.BAD_REQUEST.getMsg());
        } else if (e instanceof BindingException) {
            // mybatis未绑定异常
            return R.error(ExceptionEnum.BOUND_STATEMENT_NOT_FOUNT.getMsg());
        } else if (e instanceof CustomizeException) {
            return R.error(((CustomizeException) e).getMessage());
        } else if (e instanceof MissingServletRequestParameterException) {
            return R.error("参数绑定异常");
        } else {
            return R.error(e.getMessage());
        }
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R handleMessageNotReadableException(Exception ex, WebRequest request) {
        if (ex instanceof HttpMessageNotReadableException) {
            //404
            return R.error(ExceptionEnum.BAD_REQUEST.getMsg());
        }
        return R.error(ExceptionEnum.BAD_REQUEST.getMsg());
    }

}

