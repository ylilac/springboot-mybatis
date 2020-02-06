package com.yy.springbootmybatis.controller;

import com.yy.springbootmybatis.mapper.UserMapper;
import com.yy.springbootmybatis.model.User;
import com.yy.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/hi")
    public String sayHello(){
        return "hello";
    }

    @RequestMapping("/list")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/{name}")
    public List<User> getUsersByName(@PathVariable String name){
        System.out.println(name);
        return userService.getUsersByName(name);
    }

    @RequestMapping("/add")
    public Integer addUser(@RequestBody User user){
        System.out.println(user.toString());
        return userService.addUser(user);
    }

    @RequestMapping("/updatebyid")
    public Integer updateUserById(@RequestBody User user){
        return userService.updateUserById(user);
    }

    @RequestMapping("/delete/{id}")
    public Integer deleteUserById(@PathVariable Integer id){
        return userService.deleteUserById(id);
    }

}
