package br.com.app.inovate_barber.application.interfaces;

import br.com.app.inovate_barber.application.dto.UserResponseDto;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface UserService{
    CompletableFuture<UserResponseDto> findByEmail(String email);
    CompletableFuture<List<UserResponseDto>> getAll();
    CompletableFuture<UserResponseDto> getResultById(UUID id);
    CompletableFuture<UserResponseDto> deleteById(UUID id);
}
