package br.com.app.inovate_barber.domain.model.association;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserBarbershopId implements Serializable {
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "barbershop_id")
    private UUID barbershopId;
}
