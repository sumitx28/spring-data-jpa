package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class QueryMethodsTest {

    @Autowired
    public ProductRepository productRepository;

    @Test
    void findByName() {
        Product product = productRepository.findByName("Apple Iphone");
        System.out.println(product.getName());
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(52L).get();
        System.out.println(product.getId());

    }

    @Test
    void findByNameAndDescription() {
        List<Product> products = productRepository.findByNameOrDescription("Apple Iphone", "abc");

        products.forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findDistinct() {
        Product product = productRepository.findDistinctByName("Apple Iphone");
        System.out.println(product.getPrice());
    }

    @Test
    void findByGreaterThan(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(10));

        products.forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        });
    }

    @Test
    void findByLessThan() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(110));

        products.forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        });
    }

    @Test
    void findByContaining() {
        List<Product> products = productRepository.findByNameContaining("Iphone");

        products.forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        });
    }

    @Test
    void findByLike() {
        List<Product> products = productRepository.findByNameLike("sp%");

        products.forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        });
    }

    @Test
    void findByBetween() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(90), new BigDecimal(110));

        products.forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        });
    }

    @Test
    void findByNameIn() {
        List<Product> products = productRepository.findByNameIn(List.of("Apple", "Apple Iphone"));

        products.forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        });
    }


}