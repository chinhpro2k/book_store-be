package com.laptrinhweb.shopkibe.service;

import com.laptrinhweb.shopkibe.entity.User;
import com.laptrinhweb.shopkibe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserSevice {
    @Autowired
    private UserRepository userRepository;

    public User getUserByPhone(String phone){
        return userRepository.findByPhone(phone);
    }

    public Boolean checkExistPhone(String phone){
        return userRepository.checkExistPhone(phone) != null;
    }

    public ArrayList<User> getAllUser(){
        return userRepository.getAllUser();
    }
}
