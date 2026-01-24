package br.com.app.inovate_barber.domain.model.entity;

import br.com.app.inovate_barber.domain.model.BaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "barbershops")
@ToString(exclude = {"customers", "serviceOrders"})
public class Barbershop extends BaseModel {
    @NotBlank
    @Column(name = "fantasy_name", unique = true)
    private String fantasyName;

    @NotBlank
    @Column(name = "address")
    private String address;

    @NotBlank
    @Column(name = "uf")
    private String uf;

    @CNPJ
    @NotBlank
    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @OneToMany(mappedBy = "barbershop", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Customer> customers;

    @OneToMany(mappedBy = "barbershop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceOrder> serviceOrders;

    @OneToMany(mappedBy = "barbershop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;
}