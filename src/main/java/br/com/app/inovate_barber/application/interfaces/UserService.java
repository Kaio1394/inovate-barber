package br.com.app.inovate_barber.application.interfaces;

import br.com.app.inovate_barber.application.dto.UserResponseDto;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface UserService{
    UserResponseDto findByEmail(String email);
    List<UserResponseDto> getAll();
    UserResponseDto getResultById(UUID id);
    UserResponseDto deleteById(UUID id);
}
