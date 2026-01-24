package br.com.app.inovate_barber.domain.model.entity;

import br.com.app.inovate_barber.domain.enums.OrderStatus;
import br.com.app.inovate_barber.domain.model.BaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "services_order")
public class ServiceOrder extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "barbershop_id", nullable = false)
    private Barbershop barbershop;

    @OneToMany(mappedBy = "serviceOrder",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<FinanceServiceHistory> financeHistories;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.OPEN;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;
}
