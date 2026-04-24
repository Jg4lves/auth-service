package com.jg4lves.auth_service.controller;

import com.jg4lves.auth_service.dto.AuthDTO;
import com.jg4lves.auth_service.security.JwtUtil;
import com.jg4lves.auth_service.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação", description = "Operações de autenticação")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    @Operation(summary = "Cadastrar usuários")
    public ResponseEntity<Map<String, String>> register(@RequestBody AuthDTO body) {

        authService.register(body.email(), body.password());

        return ResponseEntity.status(201).body(
                Map.of("message", "Usuário criado com sucesso")
        );
    }

    @PostMapping("/login")
    @Operation(summary = "Realizar Login")
    public Map<String, String> login(@RequestBody AuthDTO body) {

        var user = authService.login(body.email(), body.password());

        String token = jwtUtil.generateToken(user.getEmail());

        return Map.of("token", token);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletar usuário")
    public ResponseEntity<Map<String, String>> deleteUser(HttpServletRequest request) {

        String token = request.getHeader("Authorization").replace("Bearer ", "");
        String email = jwtUtil.validateToken(token);

        authService.deleteByEmail(email);

        return ResponseEntity.ok(
                Map.of("message", "Usuário removido com sucesso")
        );
    }
}