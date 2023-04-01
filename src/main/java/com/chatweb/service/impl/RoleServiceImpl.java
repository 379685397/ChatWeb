package com.chatweb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.chatweb.domain.entity.Role;
import com.chatweb.domain.view.RoleVO;
import com.chatweb.repository.RoleRepository;
import com.chatweb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.*;


@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleRepository roleRepository;

    /**
     * 获取角色列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<Map<String, Object>> queryRoleListWithSelected(Long userId) {
        List<Role> sysRole = roleRepository.queryRoleListWithSelected(userId);
        if (CollectionUtils.isEmpty(sysRole)) {
            return null;
        }
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (Role role : sysRole) {
            map = new HashMap<String, Object>(3);
            map.put("id", role.getId());
            map.put("pId", 0);
            map.put("checked", role.getSelected() != null && role.getSelected() == 1);
            map.put("name", role.getDescription());
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public PageInfo<Role> findPageBreakByCondition(RoleVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<Role> roles = roleRepository.findAll();
        if (CollectionUtils.isEmpty(roles)) {
            return null;
        }
        PageInfo bean = new PageInfo<Role>(roles);
        bean.setList(roles);
        return bean;
    }

    /**
     * 获取用户的角色
     *
     * @param userId
     * @return
     */
    @Override
    public List<Role> listRolesByUserId(Long userId) {
        List<Role> roles = roleRepository.listRolesByUserId(userId);
        return roles;
    }

    @Override
    public Role save(Role entity) {
        Assert.notNull(entity, "Role不可为空！");
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        roleRepository.save(entity);
        return entity;
    }


    @Override
    public void delete(Long Id) {
        roleRepository.deleteById(Id);
    }

    @Override
    public Role update(Role role) {
        Assert.notNull(role, "Role不可为空！");
        role.setUpdateTime(new Date());
        return roleRepository.save(role);
    }

    @Override
    public Role getById(Long Id) {
        Assert.notNull(Id, "Id不可为空！");
        Role sysRole = roleRepository.findById(Id).get();
        return sysRole;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

}
