package com.blackfish.config;

public class CommonConstant {

    private CommonConstant() {

    }

    // 字典类型 1为单层级
    public static final String DICT_TYPE_SINGLE_LEVEL = "1";

    // 字典类型 2为多层级
    public static final String DICT_TYPE_MULTI_LEVEL = "2";

    // 状态为正常
    public static final String STATUS_NORMAL = "1";

    //状态为待启用
    public static final String STATUS_WAITING_ENABLE = "0";

    // 状态为冻结
    public static final String STATUS_DELETED = "2";

    // 菜单类型为路径
    public static final String MENU_TYPE_ROUTE = "1";

    //管理员角色名
    public static final String ROLE_ADMIN_NAME = "admin";

    // 菜单类型为按钮
    public static final String MENU_TYPE_BUTTON = "2";

    public static final String JWT_TOKEN_USERNAME = "userId";

    public static final String JWT_TOKEN_MAP_KEY_TOKEN = "token";

    public static final String JWT_TOKEN_MAP_KEY_TOKEN_EXPIRE_DATE = "expireDate";

    public static final String HEADER_JWT_TOKEN_NAME = "secretToken";

    //原始orgCode假设为0
    public static final String PARENT_ORG_ORG_CODE = "0";

    // 角色拥有权限
    public static final String ROLE_PROCESS_PERMS = "1";

    // 角色不拥有该权限
    public static final String ROLE_NOT_PROCESS_PERMS = "0";

    // 管理员角色
    public static final String ROLE_IS_ADMIN = "admin";
}
