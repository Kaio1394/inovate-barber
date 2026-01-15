package br.com.app.inovate_barber.presentation.controller;

import br.com.app.inovate_barber.application.interfaces.AuthService;
import br.com.app.inovate_barber.application.interfaces.UserService;
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
}
