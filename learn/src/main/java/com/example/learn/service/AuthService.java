package com.example.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.learn.model.Usermodel;
import com.example.learn.model.UserRoleEnum;
import com.example.learn.repository.UserRepository;
import com.example.learn.utils.AuthResponse;
import com.example.learn.utils.LoginRequest;
import com.example.learn.utils.RegisterRequest;
import com.example.learn.utils.ReturnUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final AuthenticationManager authenticationManager;

    

    public AuthResponse register(RegisterRequest registerRequest) {
        UserRoleEnum role = UserRoleEnum.USER;
        if (registerRequest.getEmail().equals("abi@gmail.com") && registerRequest.getPassword().equals("123")) {
            role = UserRoleEnum.ADMIN;
        }

        Usermodel user = Usermodel.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(role)
                .logged(true)
                .build();

        Usermodel savedUser = userRepository.save(user);
        var accessToken = jwtService.generateToken(savedUser);
        var refreshToken = refreshTokenService.createRefreshToken(savedUser.getEmail());


        
        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getRefreshToken())
                .build();
    }

    public ReturnUser login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        var user = userRepository.findByEmail(loginRequest.getEmail());
         userRepository.setloggedtrue(loginRequest.getEmail());
        var accessToken = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(loginRequest.getEmail());
        // var password=user.getPassword().dec
        // return AuthResponse.builder()
        //         .accessToken(accessToken)
        //         .refreshToken(refreshToken.getRefreshToken())
        //         .build();
        
        return ReturnUser.builder()
              .id(user.getId())
              .username(user.getUsername())
              .email(user.getEmail())
              .build()
              
        ;
    }

//     public String Logout()

    
}


