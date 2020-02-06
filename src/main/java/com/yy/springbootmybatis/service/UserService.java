package com.yy.springbootmybatis.service;

import com.yy.springbootmybatis.mapper.UserMapper;
import com.yy.springbootmybatis.model.User;
import org.apache.logging.slf4j.SLF4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

    public User getUserById(Long id){
        return userMapper.getUserById(id);
    }

    public List<User> getUsersByName(String name){
        return userMapper.getUsersByName(name);
    }

    public Integer addUser(User user){
        return userMapper.addUser(user);
    }

    public Integer updateUserById(User user){
        return userMapper.updateUserById(user);
    }

    public Integer deleteUserById(Integer id){
        return userMapper.deleteUserById(id);
    }
}
