package com.chatweb.service.impl;

import com.chatweb.domain.entity.User;
import com.chatweb.repository.UserRepository;
import com.chatweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Resource
    private JavaMailSender mailSender;

    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUser(String username, String email) {
        return userRepository.findByUserNameOrEmail(username, email);
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void updatePwd(String password, String userName) {
        userRepository.updatePassword(password, userName);
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsers(User user) {
        return userRepository.findAllByOrgId(user.getOrgId());
    }

    @Override
    public List<User> getUsersByRoleId(Long roleId) {
        return userRepository.findAllByRoleId(roleId);
    }

    @Override
    public void deleteAllUsers() {

    }
}
