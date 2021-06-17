package com.blackfish.enums;

public enum ErrorEnum {

    PARAM_NULL("101", "必填参数未添加"),
    SYSTEM_ERROR("102","系统异常"),
    BAD_REQUEST("103","错误的请求参数"),
    NOT_FOUND("104","请求路径不存在！"),
    CONNECTION_ERROR("105","网络连接请求失败！"),
    DEAL_ERROR("106","数据处理异常"),
    DATABASE_ERROR("107","数据库异常"),
    BOUND_STATEMENT_NOT_FOUNT("107","mybatis未绑定异常！"),
    NO_PERMISSION("109","非法请求！"),
    BAD_REQUEST_TYPE("110","错误的请求类型"),
    NULL_PRAM("111","请求参数空异常"),
    PROCESS_END("112","流程已结束或不存在"),
    USER_TASK_NOT_FOUND("113","当前用户任务不存在"),
    USER_NOT_FOUND("140","查询下一审批人失败"),
    PROCESS_START_ERROR("114", "流程启动失败"),
    FILE_DOWNLOAD_ERROR("115", "文件下载失败"),
    JSON_TO_BEAN_ERROR("116", "JSON转实体类异常"),
    NULL_JSON_DATA("117", "JSON数据为空"),
    NOT_FOUND_UNIT_MANAGER("118", "未查询到科室主管信息"),
    NOT_FOUND_DEPART_LEADER("119", "未查询到部门领导信息"),
    EMAIL_SEND_ERROR("120", "邮件发送失败"),
    NULL_OBJECT("121", "请求对象空异常"),
    FILE_UPLOAD_ERROR("122", "文件下载失败"),
    NULL_USER("123", "获取用户信息失败,请刷新页面重试"),
    NULL_TASK_ERROR("124", "任务不存在,无法审批"),
    UPDATE_ERROR("125", "更新数据失败"),
    DELETE_ATTACHMENT_ERROR("126", "删除附件失败"),
    DECRYPT_DATA_EROOR("127", "传入参数错误,解密失败"),
    IAM_FAILED("128","IAM接口调用失败"),
    COMPLETE_TASK_ERROR("129","完成审批任务异常"),
    INSERT_ERROR("130", "插入数据失败"),
    NOT_FOUND_EVA_INFO("131", "未查询到与该申请相关的经办审批人信息"),
    NOT_FOUND_EVA_UNIT_INFO("132", "未查询到与该申请相关的评审科室主管信息"),
    APPROVE_ERROR("134", "审批出错"),
    NOT_FOUND_PRO_MANAGER_INFO("133", "未查询到与该申请相关的项目管理员信息"), DELETE_ERROR("135","删除数据失败" ), TEAM_EXIT("136","团队信息已存在添加,不能重复添加" );



    private String code;
    private String msg;
    ErrorEnum(String code, String msg) {

        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }


}
