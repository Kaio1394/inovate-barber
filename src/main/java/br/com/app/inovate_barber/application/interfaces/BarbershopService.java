package br.com.app.inovate_barber.application.interfaces;

import br.com.app.inovate_barber.domain.model.Barbershop;
import br.com.app.inovate_barber.application.dto.*;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface BarbershopService extends BaseService<BarbershopRequestDto, BarbershopResponseDto> {
    CompletableFuture<BarbershopResponseDto> findByCnpj(String cnpj);
}
