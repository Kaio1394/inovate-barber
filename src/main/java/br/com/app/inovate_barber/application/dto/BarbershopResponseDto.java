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
    @NotBlank
    private UUID id;
    @NotBlank
    private String fantasyName;
    @NotBlank
    private String address;
    @CNPJ
    @NotBlank
    private String cnpj;
    @NotBlank
    private LocalDateTime createdAt;
    @NotBlank
    private LocalDateTime updatedAt;
}
