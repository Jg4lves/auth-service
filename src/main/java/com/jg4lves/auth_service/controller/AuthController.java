package com.jg4lves.auth_service.controller;

import com.jg4lves.auth_service.security.JwtUtil;
import com.jg4lves.auth_service.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    //Cadastra user
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Map<String, String> body) {

        authService.register(body.get("email"), body.get("password"));

        return ResponseEntity.status(201).body(
                Map.of("message", "Usuário criado com sucesso")
        );
    }

    //Faz login
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {

        var user = authService.login(body.get("email"), body.get("password"));

        String token = jwtUtil.generateToken(user.getEmail());

        return Map.of("token", token);
    }

    //Deletar user
    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, String>> deleteUser(HttpServletRequest request) {

        String token = request.getHeader("Authorization").replace("Bearer ", "");
        String email = jwtUtil.validateToken(token);

        authService.deleteByEmail(email);

        return ResponseEntity.ok(
                Map.of("message", "Usuário removido com sucesso")
        );
    }
}