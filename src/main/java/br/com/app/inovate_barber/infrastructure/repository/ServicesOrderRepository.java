package br.com.app.inovate_barber.infrastructure.repository;

import br.com.app.inovate_barber.domain.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicesOrderRepository extends JpaRepository<Service, UUID> {
}
