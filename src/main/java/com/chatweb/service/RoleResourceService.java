package com.chatweb.service;


import com.chatweb.core.object.AbstractService;
import com.chatweb.domain.entity.RoleResource;

/**
 * @author robotbird
 * @version 1.0
 * @website http://webtap.cn
 * @date 2020-04-25 20:23
 **/
public interface RoleResourceService  extends AbstractService<RoleResource,Long> {

    /**
     * 添加角色资源
     *
     * @param roleId
     * @param resourcesId
     */
    void addRoleResource(Long roleId, String resourcesId);

    /**
     * 通过角色id批量删除
     *
     * @param roleId
     */
    void removeByRoleId(Long roleId);
}
