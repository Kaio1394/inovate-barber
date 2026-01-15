package br.com.app.inovate_barber.application.interfaces;

import br.com.app.inovate_barber.application.dto.LoginRequestDto;
import br.com.app.inovate_barber.application.dto.RegisterRequestDto;
import br.com.app.inovate_barber.application.dto.TokenResponseDto;

import java.util.concurrent.CompletableFuture;

public interface AuthService {
    TokenResponseDto login(LoginRequestDto requestDto);
    void register(RegisterRequestDto requestDto);
}
