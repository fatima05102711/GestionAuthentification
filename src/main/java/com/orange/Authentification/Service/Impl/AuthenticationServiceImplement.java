package com.orange.Authentification.Service.Impl;

import com.orange.Authentification.AuthentificationResponse;
import com.orange.Authentification.Config.JwtService;
import com.orange.Authentification.Repository.UserRepository;
import com.orange.Authentification.Entity.Role;
import com.orange.Authentification.Entity.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImplement implements AuthentificationService1 {

      private final PasswordEncoder passwordEncoder;
      private final UserRepository userRepository;
      private final AuthenticationManager authenticationManager;
      private final JwtService jwtService;

    @Override
    public User register(User user) {
        User user1 = User.builder()
                .email(user.getEmail())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user1);

        return user1;

    }

    @Override
    public AuthentificationResponse authenticate(User user) {
        User user1 = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                )
        );

        //Generation token
        var token = jwtService.generateToken(user);

        return AuthentificationResponse.builder()
                .email(user1.getEmail())
                .firstname(user1.getFirstname())
                .lastname(user1.getLastname())
                .token(token)
                .build();

    }

}
