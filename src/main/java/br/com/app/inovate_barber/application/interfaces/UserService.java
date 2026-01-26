package br.com.app.inovate_barber.application.interfaces;

import br.com.app.inovate_barber.application.dto.UserRequestDto;
import br.com.app.inovate_barber.application.dto.UserResponseDto;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface UserService extends BaseService<UserResponseDto, UserRequestDto>{
    UserResponseDto findByEmail(String email);
    UserResponseDto findByFirebaseId(String firebaseId);
}
