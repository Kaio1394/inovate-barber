package br.com.app.inovate_barber.application.interfaces;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface BaseService<RequestDto, ResponseDto> {
    List<ResponseDto> getAll();

    ResponseDto getResultById(UUID id);

    ResponseDto add(RequestDto request);

    ResponseDto deleteById(UUID id);
}
