package com.stpan.springstudy.handler;

import com.stpan.springstudy.domain.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author:  STPAN
 * time:    2018/3/29 20:55
 */
//@ControllerAdvice
public class MyExceptionHandler {
    private static final String ERROR_VIEW = "error";

    //@ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        System.out.println("--------------errorHandler---------------");
        //e.printStackTrace();
        /*if (isAjax(request)) {
            return JSONResult.errorException(e.getMessage());
        } else {
            ModelAndViewContainer modelAndView = new ModelAndViewContainer();
            modelAndView.setViewName(ERROR_VIEW);
            modelAndView.addAttribute("handler", e);
            modelAndView.addAttribute("url", request.getRequestURL());
            return modelAndView;
        }*/

        return "hello world";

    }



    /**
     *
     * @Title: IMoocExceptionHandler.java
     * @Package com.imooc.handler
     * @Description: 判断是否是ajax请求
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     *
     * @author leechenxiang
     * @date 2017年12月3日 下午1:40:39
     * @version V1.0
     */
    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }
}
