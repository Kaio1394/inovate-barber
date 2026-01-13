package br.com.app.inovate_barber.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserBarbershopId implements Serializable {
    private UUID userId;
    private UUID barbershopId;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBarbershopId that)) return false;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(barbershopId, that.barbershopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, barbershopId);
    }
}
