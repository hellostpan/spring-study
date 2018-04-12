package com.stpan.springstudy.config;


import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter;
import org.springframework.context.annotation.Configuration;

/**
 * author:  STPAN
 * time:    2018/4/12 19:47
 */
@Configuration
public class MyWebMvcConfigurer extends WebMvcAutoConfiguration{
    public MyWebMvcConfigurer() {
        super();
    }

    @Override
    public OrderedHiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return super.hiddenHttpMethodFilter();
    }


    @Override
    public OrderedHttpPutFormContentFilter httpPutFormContentFilter() {
        return super.httpPutFormContentFilter();
    }


}
