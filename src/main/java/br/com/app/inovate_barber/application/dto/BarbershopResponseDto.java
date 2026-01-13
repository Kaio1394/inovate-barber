package br.com.app.inovate_barber.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BarbershopResponseDto {
    private UUID id;
    private String fantasyName;
    private String address;
    private String cnpj;
    private String uf;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
