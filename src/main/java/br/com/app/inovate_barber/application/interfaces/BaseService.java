package br.com.app.inovate_barber.application.interfaces;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface BaseService<RequestDto, ResponseDto> {
    CompletableFuture<List<ResponseDto>> getAll();

    CompletableFuture<ResponseDto> getResultById(UUID id);

    ResponseDto add(RequestDto request);

    CompletableFuture<ResponseDto> deleteById(UUID id);
}
