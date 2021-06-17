package com.blackfish.enums;


public enum ExceptionEnum {

    PARAM_NULL("1008", "必填参数未添加"), SYSTEM_ERROR("1001", "系统异常"), BAD_REQUEST("1002", "错误的请求参数"), NOT_FOUND("1003", "请求路径不存在！"), CONNECTION_ERROR("1004",
            "网络连接请求失败！"), DEAL_ERROR("1005", "数据处理异常"), DATABASE_ERROR("1006", "数据库异常"), BOUND_STATEMENT_NOT_FOUNT("1007", "mybatis未绑定异常！"), NO_PERMISSION(
            "1011", "非法请求！"), BAD_REQUEST_TYPE("1015", "错误的请求类型"),    RESPONSE_NULL("1037", "调用接口返回空数据"),IAM_FAILED("1016", "iam接口调用失败");


    private String code;
    private String msg;

    ExceptionEnum(String code, String msg) {

        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }



    public String getMsg() {
        return msg;
    }




}
