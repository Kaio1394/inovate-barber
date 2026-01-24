package br.com.app.inovate_barber.infrastructure.repository;

import br.com.app.inovate_barber.domain.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
