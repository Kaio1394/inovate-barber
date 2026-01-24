package br.com.app.inovate_barber.infrastructure.repository;

import br.com.app.inovate_barber.domain.model.entity.Barbershop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BarbershopRepository extends JpaRepository<Barbershop, UUID> {
}
