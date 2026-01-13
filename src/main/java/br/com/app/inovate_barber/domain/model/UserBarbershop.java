package br.com.app.inovate_barber.domain.model;

import br.com.app.inovate_barber.domain.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_barbershop")
@Schema(hidden = true)
public class UserBarbershop {
    @EmbeddedId
    private UserBarbershopId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("barbershopId")
    @JoinColumn(name = "barbershop_id")
    private Barbershop barbershop;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
