package br.com.app.inovate_barber.application.service;

import br.com.app.inovate_barber.application.dto.UserRequestDto;
import br.com.app.inovate_barber.application.dto.UserResponseDto;
import br.com.app.inovate_barber.application.interfaces.UserService;
import br.com.app.inovate_barber.domain.exception.EntityNotFoundException;
import br.com.app.inovate_barber.domain.model.entity.User;
import br.com.app.inovate_barber.infrastructure.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<UserRequestDto> findAll() {
        return List.of();
    }

    @Override
    public UserRequestDto findById(UUID id) {
        return null;
    }

    @Override
    public UserRequestDto add(UserResponseDto request) {
        return null;
    }

    @Override
    public UserRequestDto update(UserResponseDto request, UUID id) {
        return null;
    }

    @Override
    public UserRequestDto deleteById(UUID id) {
        return null;
    }

    @Override
    public UserResponseDto findByEmail(String email) {
        return null;
    }

    @Override
    public UserResponseDto findByFirebaseId(String firebaseId) {
        return null;
    }
}
