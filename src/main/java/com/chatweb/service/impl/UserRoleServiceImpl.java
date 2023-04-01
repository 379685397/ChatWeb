package com.chatweb.service.impl;


import com.chatweb.domain.entity.UserRole;
import com.chatweb.repository.UserRoleRepository;
import com.chatweb.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    /**
     * 添加用户角色
     *
     * @param userId
     * @param roleIds
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public void addUserRole(Long userId, String roleIds) {
        //删除
        removeByUserId(userId);
        //添加
        String[] roleIdArr = roleIds.split(",");
        if (roleIdArr.length == 0) {
            return;
        }
        UserRole u = null;
        List<UserRole> roles = new ArrayList<>();
        for (String roleId : roleIdArr) {
            u = new UserRole();
            u.setUserId(userId);
            u.setRoleId(Long.parseLong(roleId));
            save(u);
        }

    }

    @Override
    public void removeByUserId(Long userId) {

    }

    @Override
    public UserRole save(UserRole entity) {
        Assert.notNull(entity, "UserRole不可为空！");
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        userRoleRepository.save(entity);
        return entity;
    }


    @Override
    public void delete(Long Id) {
        userRoleRepository.deleteById(Id);
    }

    @Override
    public UserRole update(UserRole role) {
        Assert.notNull(role, "UserRole不可为空！");
        role.setUpdateTime(new Date());
        return userRoleRepository.save(role);
    }

    @Override
    public UserRole getById(Long Id) {
        Assert.notNull(Id, "Id不可为空！");
        UserRole sysRole = userRoleRepository.findById(Id).get();
        return sysRole;
    }

    @Override
    public List<UserRole> findAll() {
        List<UserRole> roles = userRoleRepository.findAll();
        return roles;
    }
}
