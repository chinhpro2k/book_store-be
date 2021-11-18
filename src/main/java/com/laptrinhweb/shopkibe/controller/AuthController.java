package com.laptrinhweb.shopkibe.controller;

import com.laptrinhweb.shopkibe.entity.Otp;
import com.laptrinhweb.shopkibe.entity.Shop;
import com.laptrinhweb.shopkibe.entity.User;
import com.laptrinhweb.shopkibe.payload.ApiResponse;
import com.laptrinhweb.shopkibe.payload.auth.AuthRequest;
import com.laptrinhweb.shopkibe.payload.auth.LoginResponse;
import com.laptrinhweb.shopkibe.payload.auth.OTPRequest;
import com.laptrinhweb.shopkibe.repository.OtpRepository;
import com.laptrinhweb.shopkibe.repository.ShopRepository;
import com.laptrinhweb.shopkibe.repository.UserRepository;
import com.laptrinhweb.shopkibe.security.CustomUserDetails;
import com.laptrinhweb.shopkibe.security.JwtTokenProvider;
import com.laptrinhweb.shopkibe.service.MailService;
import com.laptrinhweb.shopkibe.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private UserSevice userSevice;

    @Autowired
    private MailService mailService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody AuthRequest authRequest) {
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

    @PostMapping("/checkHasShop")
    public ApiResponse checkHasShop(@RequestBody AuthRequest authRequest ){
        User user = userSevice.getUserByPhone(authRequest.getPhone());
        if(user.getShop_id() == null)
            return new ApiResponse(0);
        return new ApiResponse(1);
    }

    @PostMapping("/sendmail")
    public ApiResponse sendMail(@RequestBody OTPRequest otpRequest){
        ApiResponse response = new ApiResponse();
        long otpCode = (long)Math.floor(Math.random()*9000+1000);
        User user = userRepository.findByEmail(otpRequest.getEmail());
        if (user != null) {
            response.setError(1);
            response.setMsg("Email da ton tai");
        } else {
            response.setError(0);
            mailService.sendSimpleEmail(otpRequest.getEmail() ,String.valueOf(otpCode));
            Otp otp = new Otp(otpRequest.getId(), otpCode);
            otpRepository.save(otp);
        }
        return response;
    }

    @PostMapping("/confirmOTP")
    public ApiResponse confirmOtp(@RequestBody OTPRequest otpRequest){
        ArrayList<Otp> otpArrayList = otpRepository.getOtpByUserId(otpRequest.getId());
        if(!Objects.equals(otpArrayList.get(otpArrayList.size() - 1).getOtp(), otpRequest.getOtp())){
            return new ApiResponse(1);
        }
        Shop shop = new Shop();

        return new ApiResponse(0);
    }

    @PostMapping("/createShop")
    public ApiResponse createShop(@RequestBody OTPRequest otpRequest){
            Shop shop = new Shop(otpRequest.getShopName(), otpRequest.getShopAddress(), otpRequest.getId());
            Shop shopCreated = shopRepository.save(shop);
            User user = userRepository.findById(otpRequest.getId()).orElseThrow();
            user.setEmail(otpRequest.getEmail());
            user.setShop_id(shopCreated.getId());
            userRepository.save(user);
            return new ApiResponse(0);
    }
}

