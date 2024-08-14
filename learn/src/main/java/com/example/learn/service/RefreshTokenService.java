package com.example.learn.service;

import org.springframework.stereotype.Service;
import com.example.learn.model.RefreshToken;
import com.example.learn.model.Usermodel;
import com.example.learn.repository.RefreshTokenRepository;
import com.example.learn.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    public RefreshTokenService(UserRepository userRepository, RefreshTokenRepository refreshTokenRepository) {
        this.userRepository = userRepository;
        this.refreshTokenRepository = refreshTokenRepository;
    }
    public RefreshToken createRefreshToken(String email) {
        Usermodel user=userRepository.findByEmail(email);
        RefreshToken refreshToken = user.getRefreshToken();


        if (refreshToken == null) {
            long refreshTokenValidity = 30 * 24 * 60 * 60 * 1000;
            refreshToken = RefreshToken.builder()
                    .refreshToken(UUID.randomUUID().toString())
                    .expiryDate(Instant.now().plusMillis(refreshTokenValidity))
                    .usermodel(user)
                    .build();

            refreshTokenRepository.save(refreshToken);
        }

        // refreshToken.setRefreshToken(UUID.randomUUID().toString());
        // refreshToken.setExpiryDate(Instant.now().plusMillis(1000 * 60 * 60 * 24 * 30));
        // refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyRefreshToken(String refreshToken) {
        RefreshToken refToken = refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new RuntimeException("Refresh token not found!"));

        if (refToken.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(refToken);
            throw new RuntimeException("Refresh Token expired");
        }
        return refToken;
    }
}

