package br.com.app.inovate_barber.application.interfaces;

import br.com.app.inovate_barber.domain.model.User;

import java.util.UUID;

public interface JwtService {
    String generate(User user);
    boolean isValid(String token);
}
