package com.laptrinhweb.shopkibe.service;

import com.laptrinhweb.shopkibe.entity.User;
import com.laptrinhweb.shopkibe.repository.UserRepository;
import com.laptrinhweb.shopkibe.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = userRepository.findByPhone(phone);
        if(user == null ) throw new UsernameNotFoundException(phone);
        return new CustomUserDetails(user);
    }

    public UserDetails loadUserByPhone(String phone) throws UsernameNotFoundException{
        User user = userRepository.findByPhone(phone);
        if(user== null) throw new UsernameNotFoundException(phone);
        return new CustomUserDetails(user);
    }

}
