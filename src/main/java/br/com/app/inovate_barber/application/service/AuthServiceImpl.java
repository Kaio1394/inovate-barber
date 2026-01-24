//package br.com.app.inovate_barber.application.service;
//
//import br.com.app.inovate_barber.application.dto.*;
//import br.com.app.inovate_barber.application.interfaces.AuthService;
//import br.com.app.inovate_barber.application.interfaces.JwtService;
//import br.com.app.inovate_barber.domain.exception.EntityAlreadyExistsException;
//import br.com.app.inovate_barber.domain.model.barbershop.User;
//import br.com.app.inovate_barber.infrastructure.repository.UserRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.concurrent.CompletableFuture;
//
//@Service
//public class AuthServiceImpl implements AuthService {
//    private final PasswordEncoder encoder;
//    private final UserRepository userRepository;
//    private final ModelMapper mapper;
//    private final JwtService jwtService;
//
//    public AuthServiceImpl(PasswordEncoder encoder, UserRepository userRepository, ModelMapper mapper, JwtService jwtService) {
//        this.encoder = encoder;
//        this.userRepository = userRepository;
//        this.mapper = mapper;
//        this.jwtService = jwtService;
//    }
//
//    @Override
//    public TokenResponseDto login(LoginRequestDto requestDto) {
//        var user = userRepository.findByEmail(requestDto.getEmail())
//                .orElseThrow(() -> new BadCredentialsException(""));
//        if (!encoder.matches(requestDto.getPassword(), user.getPassword())) {
//            throw new BadCredentialsException("");
//        }
//        var token = jwtService.generate(user);
//        return new TokenResponseDto(token, jwtService.getExpiration());
//    }
//
//    @Transactional
//    @Override
//    public RegisterResponseDto register(RegisterRequestDto requestDto) {
//        userRepository.findByEmail(requestDto.getEmail())
//                .ifPresent(b -> {
//                    throw new EntityAlreadyExistsException();
//                });
//
//        User userModel = mapper.map(requestDto, User.class);
//        var pass = userModel.getPassword();
//        userModel.setPassword(encoder.encode(pass));
//        userModel = userRepository.save(userModel);
//        return mapper.map(userModel, RegisterResponseDto.class);
//    }
//}
