package org.example.jiraproject1.controller;

import lombok.RequiredArgsConstructor;
import org.example.jiraproject1.service.AuthService;
import org.example.jiraproject1.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")  // path

    public ResponseEntity<String> signup(@RequestBody User user) {
        return ResponseEntity.ok(authService.signUp(user.getUsername(), user.getPassword()));

    }

    @PostMapping("/signin")

    public ResponseEntity<String> signin(@RequestBody User user) {
        String token = authService.signIn(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(token);
    }

}