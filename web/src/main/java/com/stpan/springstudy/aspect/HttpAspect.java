package com.stpan.springstudy.aspect;

import com.alibaba.druid.support.json.JSONUtils;
import com.stpan.springstudy.utils.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * author:  STPAN
 * time:    2018/4/13 20:13
 */
@Aspect
@Component
public class HttpAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.stpan.springstudy.controller.*.*(..))")//进入controller方法之前
    public void log(){
    }

    @Before("log()")//进入controller方法之前
    public void logBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        /*//url
        LOGGER.info("url={}", request.getRequestURL());
        //method
        LOGGER.info("method={}", request.getMethod());
        //ip
        LOGGER.info("ip={}", request.getRemoteAddr());
        //类方法
        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        LOGGER.info("args={}", joinPoint.getArgs());*/
        LOGGER.info("---------------before hello world!---------------");
    }

    @After("log()")//进入controller方法之前
    public void logAfter(){
        LOGGER.info("---------------after hello world!---------------");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        LOGGER.info("response={}", JsonUtils.objectToJson(object));
    }
}
