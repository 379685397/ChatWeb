package com.chatweb.service;

import com.chatweb.domain.entity.User;

import java.util.List;

public interface UserService {


    /**
     * 获取用户
     *
     * @param id
     * @return
     */
    public User getUser(Long id);

    /**
     * user name
     *
     * @param userName
     * @return
     */
    public User getUserByUserName(String userName);


    /**
     * email
     *
     * @param email
     * @return
     */
    public User getUserByEmail(String email);

    /**
     * get user by username and email
     *
     * @param username
     * @param email
     * @return
     */
    public User getUser(String username, String email);

    /**
     * 新增一个用户
     *
     * @param user
     */
    void create(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    void update(User user);

    /**
     * update user's password
     *
     * @param password
     * @param userName
     */
    void updatePwd(String password, String userName);

    /**
     * delete by user id
     *
     * @param id
     */
    void delete(Long id);

    /**
     * return all user
     */
    public List<User> getUsers(User user);


    /**
     * return users by roleId
     *
     * @param roleId
     * @return
     */
    public List<User> getUsersByRoleId(Long roleId);

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

}