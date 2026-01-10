package br.com.app.inovate_barber.infrastructure.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.inovate_barber.domain.model.Barbershop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BarberShopRepository extends JpaRepository<Barbershop, UUID> {
    @Query("SELECT t FROM Barbershop t WHERE t.fantasyName = :fantasyName")
    Optional<Barbershop> findByFantasyName(@Param("fantasyName") String fantasyName);

    @Query("SELECT t FROM Barbershop t WHERE t.cnpj = :cnpj")
    Optional<Barbershop> findByCnpj(@Param("cnpj") String cnpj);
}
