package br.com.app.inovate_barber.presentation.controller;

import br.com.app.inovate_barber.domain.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class HealthController {
	@GetMapping("health-check")
	public ResponseEntity<?> healthCheck() {
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}