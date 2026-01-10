package br.com.app.inovate_barber.application.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import br.com.app.inovate_barber.domain.exception.EntityAlreadyExistsException;
import br.com.app.inovate_barber.domain.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.inovate_barber.application.dto.BarbershopRequestDto;
import br.com.app.inovate_barber.application.dto.BarbershopResponseDto;
import br.com.app.inovate_barber.application.interfaces.BarbershopService;
import br.com.app.inovate_barber.domain.model.Barbershop;
import br.com.app.inovate_barber.infrastructure.repository.BarberShopRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class BarbershopServiceImpl implements BarbershopService {
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private BarberShopRepository repository;

	@Override
	public CompletableFuture<List<BarbershopResponseDto>> getAll() {
		return CompletableFuture.supplyAsync(() -> {
			List<Barbershop> listModel = repository.findAll();
			return listModel.stream()
					.map(item -> mapper.map(item, BarbershopResponseDto.class))
					.toList();
		});
	}

	@Override
	public CompletableFuture<BarbershopResponseDto> getResultById(UUID id) {
		return CompletableFuture.supplyAsync(() -> {
			var model = repository.findById(id).orElseThrow(EntityNotFoundException::new);
			return mapper.map(model, BarbershopResponseDto.class);
		});
	}

	@Transactional
	@Override
	public BarbershopResponseDto add(BarbershopRequestDto request){
		repository.findByCnpj(request.getCnpj())
				.ifPresent(b -> {
					throw new EntityAlreadyExistsException();
				});
		Barbershop model = mapper.map(request, Barbershop.class);
		model = repository.save(model);
		return mapper.map(model, BarbershopResponseDto.class);
	}

	@Override
	public CompletableFuture<BarbershopResponseDto> deleteById(UUID id) {
		return CompletableFuture.supplyAsync(() -> {
			var model = repository.findById(id).orElseThrow(EntityNotFoundException::new);
			repository.delete(model);
			return mapper.map(model, BarbershopResponseDto.class);
		});
	}

	@Override
	public CompletableFuture<BarbershopResponseDto> findByCnpj(String cnpj) {
		return CompletableFuture.supplyAsync(() -> {
			var model = repository.findByCnpj(cnpj).orElseThrow(EntityNotFoundException::new);
			return mapper.map(model, BarbershopResponseDto.class);
		});
	}
}
