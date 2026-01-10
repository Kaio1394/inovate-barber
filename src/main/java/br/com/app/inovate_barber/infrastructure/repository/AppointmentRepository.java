package br.com.app.inovate_barber.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.inovate_barber.domain.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

}
