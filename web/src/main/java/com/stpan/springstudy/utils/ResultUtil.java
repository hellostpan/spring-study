package com.stpan.springstudy.utils;

/**
 * author:  STPAN
 * time:    2018/4/13 21:05
 */
public class ResultUtil {

    public static Result success(Object o){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(o);
        return result;
    }

    public static Result failed(){
        Result result = new Result();
        result.setCode(ResultEnum.FAILED.getCode());
        result.setMsg(ResultEnum.FAILED.getMsg());
        return result;
    }
    public static Result failed(String msg){
        Result result = new Result();
        result.setCode(ResultEnum.FAILED.getCode());
        result.setMsg(msg);
        return result;
    }
    public static Result failed(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
