package br.com.app.inovate_barber.domain.model.entity;

import br.com.app.inovate_barber.domain.enums.ProductType;
import br.com.app.inovate_barber.domain.enums.ProductUnit;
import br.com.app.inovate_barber.domain.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseModel {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barbershop_id", nullable = false)
    @JsonIgnore
    private Barbershop barbershop;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "sku", unique = true)
    private String sku;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "product_unit")
    private ProductUnit productUnit;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "product_type")
    private ProductType productType;

    @Column(name = "cost_price")
    private BigDecimal costPrice;

    @Column(name = "sale_price")
    private BigDecimal salePrice;
}
