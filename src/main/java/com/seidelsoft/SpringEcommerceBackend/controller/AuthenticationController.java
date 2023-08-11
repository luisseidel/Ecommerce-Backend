package com.seidelsoft.SpringEcommerceBackend.controller;

import com.seidelsoft.SpringEcommerceBackend.model.dto.in.AuthenticationRequest;
import com.seidelsoft.SpringEcommerceBackend.model.dto.in.RegisterRequest;
import com.seidelsoft.SpringEcommerceBackend.model.dto.out.AuthenticationResponse;
import com.seidelsoft.SpringEcommerceBackend.model.entity.User;
import com.seidelsoft.SpringEcommerceBackend.repository.UserRepository;
import com.seidelsoft.SpringEcommerceBackend.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;
    @Autowired
    private UserRepository repository;

    @PostMapping("/register")
    public ResponseEntity<Object> register(
        @Valid @RequestBody RegisterRequest request
    ) {
        Optional<User> existingUser = repository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("Erro: Usuário já existe!");
        }
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @Valid @RequestBody AuthenticationRequest request
    ) {
        try {
            return ResponseEntity.ok(service.authenticate(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

}
