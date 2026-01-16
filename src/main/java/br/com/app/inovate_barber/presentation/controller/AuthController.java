package br.com.app.inovate_barber.presentation.controller;

import br.com.app.inovate_barber.application.dto.LoginRequestDto;
import br.com.app.inovate_barber.application.dto.RegisterRequestDto;
import br.com.app.inovate_barber.application.interfaces.AuthService;
import br.com.app.inovate_barber.application.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto requestDto){
        var resp = authService.register(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequestDto requestDto){
        var resp = authService.login(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
