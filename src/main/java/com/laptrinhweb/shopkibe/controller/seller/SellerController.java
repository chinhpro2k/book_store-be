package com.laptrinhweb.shopkibe.controller.seller;

import com.laptrinhweb.shopkibe.entity.User;
import com.laptrinhweb.shopkibe.payload.ApiResponse;
import com.laptrinhweb.shopkibe.payload.auth.AuthRequest;
import com.laptrinhweb.shopkibe.payload.auth.LoginResponse;
import com.laptrinhweb.shopkibe.repository.UserRepository;
import com.laptrinhweb.shopkibe.security.CustomUserDetails;
import com.laptrinhweb.shopkibe.security.JwtTokenProvider;
import com.laptrinhweb.shopkibe.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller/api/auth")
public class SellerController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserSevice userSevice;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getPhone(),
                        authRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());

        User user = userSevice.getUserByPhone(authRequest.getPhone());

        return new LoginResponse(token, user);
    }

    @PostMapping("/signup")
    public ApiResponse signUp(@RequestBody AuthRequest authRequest){
        if(userSevice.checkExistPhone(authRequest.getPhone())){
            return new ApiResponse(1, "Phone is already used");
        }

        String phone = authRequest.getPhone();
        String password = passwordEncoder.encode(authRequest.getPassword());

        User user = new User(phone, password);

        userRepository.save(user);

        return new ApiResponse(0);
    }



}
