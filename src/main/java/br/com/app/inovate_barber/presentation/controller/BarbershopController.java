//package br.com.app.inovate_barber.presentation.controller;
//
//import java.util.UUID;
//import java.util.concurrent.CompletableFuture;
//
//import br.com.app.inovate_barber.application.dto.BarbershopRequestDto;
//import br.com.app.inovate_barber.domain.responses.ErrorResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//import br.com.app.inovate_barber.application.dto.BarbershopResponseDto;
//import br.com.app.inovate_barber.application.interfaces.BarbershopService;
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//@RequestMapping("api/v1/barbershop")
//@Slf4j
//public class BarbershopController {
//	private final BarbershopService barbershopService;
//
//	public BarbershopController(BarbershopService barbershopService) {
//		this.barbershopService = barbershopService;
//	}
//
//	@GetMapping("list")
//	public ResponseEntity<?> getAll(){
//		var list = barbershopService.getAll();
//		return ResponseEntity.status(HttpStatus.OK).body(list);
//	}
//
//	@GetMapping("id/{id}")
//	public ResponseEntity<?> findByid(@PathVariable UUID id){
//		var barbershop = barbershopService.getResultById(id);
//		return ResponseEntity.status(HttpStatus.OK).body(barbershop);
//	}
//
//	@PostMapping
//	public ResponseEntity<?> add(@RequestBody BarbershopRequestDto dto) {
//		BarbershopResponseDto result = barbershopService.add(dto);
//		return ResponseEntity.status(HttpStatus.CREATED).body(result);
//	}
//}
