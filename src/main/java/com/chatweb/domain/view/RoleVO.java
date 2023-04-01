package com.chatweb.domain.view;

import com.chatweb.domain.entity.Role;
import groovy.transform.EqualsAndHashCode;

/**
 * @author robotbird
 * @version 1.0
 * @website http://webtap.cn
 * @date 2020-04-26 20:30
 **/
@EqualsAndHashCode(callSuper = false)
public class RoleVO extends BaseVO {
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
