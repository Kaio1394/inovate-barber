package br.com.app.inovate_barber.application.service;

import br.com.app.inovate_barber.application.dto.UserResponseDto;
import br.com.app.inovate_barber.application.interfaces.UserService;
import br.com.app.inovate_barber.domain.exception.EntityNotFoundException;
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
    public List<UserResponseDto> getAll() {
        var listModel = repository.findAll();
        return listModel.stream()
                .map(x -> mapper.map(x, UserResponseDto.class))
                .toList();
    }

    @Override
    public UserResponseDto getResultById(UUID id) {
        var model = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.map(model, UserResponseDto.class);
    }

    @Override
    public UserResponseDto deleteById(UUID id) {
        return null;
    }

    @Override
    public UserResponseDto findByEmail(String email) {
        return null;
    }
}
