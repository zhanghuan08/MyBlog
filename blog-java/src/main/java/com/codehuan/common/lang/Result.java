package com.codehuan.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZhangHuan created on 2021/2/8
 */
@Data
public class Result implements Serializable {

    /**
     * 200是正常，非200异常
     */
    private int code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;

    public static Result success(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result success(Object data) {
        return success(200, "操作成功", data);
    }

    public static Result fail(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result fail(String msg, Object data) {
        return fail(400, msg, "操作失败");
    }

    public static Result fail(String msg) {
        return fail(400, msg, null);
    }
}
