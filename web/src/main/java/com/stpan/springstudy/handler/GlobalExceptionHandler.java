package com.stpan.springstudy.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * author:  STPAN
 * time:    2018/4/2 19:56
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 所有异常报错
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=Exception.class)
    public String allExceptionHandler(Exception e)
    {
        e.printStackTrace();
//        ex.printStackTrace();
        System.out.println("----------------------------------------");
        return "服务器异常，请联系管理员！";
    }

    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }

}
