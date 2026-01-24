package br.com.app.inovate_barber.domain.model.entity;

import br.com.app.inovate_barber.domain.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer extends BaseModel {
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @CPF
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "phone", nullable = false)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barbershop_id", nullable = false)
    @JsonIgnore
    private Barbershop barbershop;
}
