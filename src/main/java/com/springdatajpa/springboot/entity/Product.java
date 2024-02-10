package com.springdatajpa.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name="product",
        uniqueConstraints = {
                @UniqueConstraint(
                        name="sku_unique",
                        columnNames = "stock_keeping_unit"
)})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
//    @SequenceGenerator(name="product_generator", sequenceName = "product_sequence", allocationSize = 1)
    private long id;
    @Column(name="stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false, length = 200)
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean active;
    private String imageURL;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

}
