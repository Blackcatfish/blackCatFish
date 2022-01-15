package com.blackfish.shiro.vo;

import java.util.HashMap;

public class R extends HashMap <String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 200);
        put("reason", "SUCCESS");
        put("message",null);
    }

    public static R error() {
        return error(1, "操作失败");
    }

    public static R error(String msg) {
        return error(500, msg);
    }
    public static R error(Object msg) {
        R r = new R();
        r.put("code", 500);
        r.put("data", msg);
        r.put("reason",null);
        return r;
    }
    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("message", msg);
        r.put("reason",null);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("message", msg);
        return r;
    }

    public static R ok(Object object) {
        R r = new R();
        r.put("data", object);
        return r;
    }
    public static R ok() {
        R r = new R();
        return r;
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
