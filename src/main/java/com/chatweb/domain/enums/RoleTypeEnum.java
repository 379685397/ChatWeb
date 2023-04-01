package com.chatweb.domain.enums;

import org.springframework.util.StringUtils;

public enum RoleTypeEnum {
    ROOT("root"),
    ADMIN("admin"),
    USER("user"),
    UNKNOW("guest");
    private String desc;

    RoleTypeEnum(String desc) {
        this.desc = desc;
    }

    public static RoleTypeEnum getByType(String type) {
        if (StringUtils.isEmpty(type)) {
            return RoleTypeEnum.UNKNOW;
        }
        for (RoleTypeEnum ut : RoleTypeEnum.values()) {
            if (ut.toString().equalsIgnoreCase(type)) {
                return ut;
            }
        }
        return RoleTypeEnum.UNKNOW;
    }

    public String getDesc() {
        return desc;
    }
}
