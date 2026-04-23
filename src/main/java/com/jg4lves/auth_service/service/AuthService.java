package com.jg4lves.auth_service.service;

import com.jg4lves.auth_service.model.User;
import com.jg4lves.auth_service.store.UserStore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String register(String email, String password) {

        if (UserStore.users.containsKey(email)) {
            throw new RuntimeException("Usuário já existe");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setRole("USER");

        UserStore.users.put(email, user);

        return "Usuário criado";
    }

    public User login(String email, String password) {

        User user = UserStore.users.get(email);

        if (user == null || !encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Credenciais inválidas");
        }

        return user;
    }

    public void deleteByEmail(String email) {

        if (!UserStore.users.containsKey(email)) {
            throw new RuntimeException("Usuário não encontrado");
        }

        UserStore.users.remove(email);
    }
}