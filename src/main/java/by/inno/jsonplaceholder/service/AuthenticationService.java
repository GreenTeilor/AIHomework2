package by.inno.jsonplaceholder.service;

import by.inno.jsonplaceholder.dto.AuthenticationRequest;
import by.inno.jsonplaceholder.dto.AuthenticationResponse;
import by.inno.jsonplaceholder.dto.RegisterRequest;
import by.inno.jsonplaceholder.entity.Authentication;
import by.inno.jsonplaceholder.entity.Role;
import by.inno.jsonplaceholder.repository.AuthenticationRepository;
import by.inno.jsonplaceholder.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationRepository authenticationRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        if (authenticationRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        var authentication = Authentication.builder()
                .id(UUID.randomUUID())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .role(Role.USER)
                .build();
        authenticationRepository.save(authentication);

        var accessToken = jwtService.generateAccessToken(authentication);
        var refreshToken = jwtService.generateRefreshToken(authentication);

        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var authentication = authenticationRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        var accessToken = jwtService.generateAccessToken(authentication);
        var refreshToken = jwtService.generateRefreshToken(authentication);

        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse refreshToken(String refreshToken) {
        String userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail == null) {
            throw new RuntimeException("Invalid refresh token");
        }

        var authentication = authenticationRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!jwtService.isTokenValid(refreshToken, authentication)) {
            throw new RuntimeException("Invalid refresh token");
        }

        var accessToken = jwtService.generateAccessToken(authentication);
        var newRefreshToken = jwtService.generateRefreshToken(authentication);

        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(newRefreshToken)
                .build();
    }

    public Authentication getSelf() {
        UUID userId = ((Authentication) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return authenticationRepository.findById(userId).orElseThrow(RuntimeException::new);
    }
} 