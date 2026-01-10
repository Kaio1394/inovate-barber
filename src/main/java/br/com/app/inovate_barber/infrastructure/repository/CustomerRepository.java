package br.com.app.inovate_barber.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.inovate_barber.domain.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
