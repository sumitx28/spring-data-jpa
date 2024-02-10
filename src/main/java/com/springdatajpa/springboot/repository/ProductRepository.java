package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product findByName(String name);

    Optional<Product> findById(Long id);

    List<Product> findByNameAndDescription(String name, String description);

    List<Product> findByNameOrDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameLike(String condition);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<Product> findByDateCreatedBetween(LocalDateTime startTime, LocalDateTime endTime);

    List<Product> findByNameIn(List<String> names);

    List<Product> findFirst2ByOrderByNameAsc(String name);

}
