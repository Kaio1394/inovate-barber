package br.com.app.inovate_barber.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BarbershopRequestDto {
    @NotBlank
    private String fantasyName;
    @NotBlank
    private String address;
    @CNPJ
    @NotBlank
    private String cnpj;
}
