package br.com.app.inovate_barber.infrastructure.repository;

import br.com.app.inovate_barber.domain.model.UserBarbershop;
import br.com.app.inovate_barber.domain.model.UserBarbershopId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBarbershopRepository extends JpaRepository<UserBarbershop, UserBarbershopId> {

}
