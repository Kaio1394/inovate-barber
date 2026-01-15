package br.com.app.inovate_barber.presentation.controller;

import br.com.app.inovate_barber.application.dto.UserRequestDto;
import br.com.app.inovate_barber.application.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("list")
    public CompletableFuture<ResponseEntity<?>> getAllUser(){
        return userService.getAll()
                .thenApply(ResponseEntity::ok);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody UserRequestDto userDto){
        var userResponseDto = userService.add(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

}
