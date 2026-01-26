package br.com.app.inovate_barber.domain.model.association;

import br.com.app.inovate_barber.domain.model.entity.Barbershop;
import br.com.app.inovate_barber.domain.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_barbershop")
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
}

