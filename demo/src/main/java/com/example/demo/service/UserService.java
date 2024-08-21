package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public boolean register(User user) {
        int result = userMapper.insert(user);
        if (result == -1) {
            System.out.println("User already exists");
            return false;
        }else{
            System.out.println("User registered");
            return true;
        }
    }
    public boolean login(User user) {
        User result = userMapper.selectByPrimaryKey(user.getId());
        if (result == null) {
            System.out.println("User not found");
            return false;}
        if (result.getPassword().equals(user.getPassword())) {
            System.out.println("User logged in");
            user.setType(result.getType());
            return true;
        } else {
            System.out.println("Wrong password");
            return false;
        }
    }
    public boolean logout() {
        System.out.println("User logged out");
        return true;
    }

    public void updateProfile(User user) {
        userMapper.updateByPrimaryKey(user);
        System.out.println("User profile updated");
    }
    public boolean deleteProfile(int id) {
        int i = userMapper.deleteByPrimaryKey(id);
        if (i == -1) {
            System.out.println("User not found");
            return false;
        }else {
            System.out.println("User profile deleted");
            return true;
        }
    }
}
