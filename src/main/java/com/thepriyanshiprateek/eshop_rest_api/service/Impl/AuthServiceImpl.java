package com.thepriyanshiprateek.eshop_rest_api.service.Impl;

import com.thepriyanshiprateek.eshop_rest_api.entity.User;
import com.thepriyanshiprateek.eshop_rest_api.payload.LoginDto;
import com.thepriyanshiprateek.eshop_rest_api.payload.RegisterDto;
import com.thepriyanshiprateek.eshop_rest_api.repository.RoleRepository;
import com.thepriyanshiprateek.eshop_rest_api.repository.UserRepository;
import com.thepriyanshiprateek.eshop_rest_api.security.JwtTokenProvider;
import com.thepriyanshiprateek.eshop_rest_api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Override
    public String login(LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        System.out.println(token);
        return token;
    }

    @Override
    public String register(RegisterDto registerDto){
//        check for username exist in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            return "Username is already taken.";
        }
        if(UserRepository.existsByEmail(registerDto.getEmail())){
            return "Email is already taken.";
        }
//        create a new user
        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());

    }

}
