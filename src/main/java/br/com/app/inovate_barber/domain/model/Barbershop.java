package br.com.app.inovate_barber.domain.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "barbershops")
public class Barbershop extends BaseModel {
    @NotBlank
    @Column(name = "fantasy_name", unique = true)
    private String fantasyName;

    @NotBlank
    @Column(name = "address")
    private String address;

    @CNPJ
    @NotBlank
    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @OneToMany(mappedBy = "barbershop", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
    private List<Barber> barbers = new ArrayList<>();
}
