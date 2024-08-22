package com.app.controller;

import com.app.config.JwtProvider;
import com.app.repository.CartRepository;
import com.app.repository.UserRepository;
import com.app.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtProvider jwtProvider;
    @Autowired
    private final CustomUserDetailService customUserDetailService;
    @Autowired
    private final CartRepository cartRepository;


    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder,
                          JwtProvider jwtProvider, CustomUserDetailService customUserDetailService,
                          CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.customUserDetailService = customUserDetailService;
        this.cartRepository = cartRepository;
    }


}