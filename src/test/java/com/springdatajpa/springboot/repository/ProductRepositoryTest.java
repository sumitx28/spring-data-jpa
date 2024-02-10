package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveTest() {
        Product product = new Product();
        product.setName("Apple Iphone");
        product.setPrice(new BigDecimal(100));
        product.setDescription("Something");
        product.setImageURL("slkjfvf");
        product.setActive(true);
        product.setSku("Something");

        Product savedObject = productRepository.save(product);

        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSave(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        product.setActive(false);

        productRepository.save(product);

        System.out.println(productRepository.findById(id).get().getActive());
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        System.out.println(product.toString());
    }

    @Test
    void saveAllMethod() {
        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setName("Apple Iphone 11");
        product1.setPrice(new BigDecimal(100));
        product1.setDescription("Something");
        product1.setImageURL("abcd");
        product1.setActive(true);
        product1.setSku("abcd");

        Product product2 = new Product();
        product2.setName("Apple Iphone 12");
        product2.setPrice(new BigDecimal(120));
        product2.setDescription("Something");
        product2.setImageURL("abcde");
        product2.setActive(true);
        product2.setSku("abcde");

        products.add(product1);
        products.add(product2);

        List<Product> savedProducts = productRepository.saveAll(products);

        for(Product p: savedProducts) {
            System.out.println(p.getName());
        }
    }

    @Test
    void findAllMethod() {
        List<Product> allSavedProducts = productRepository.findAll();

        for(Product p: allSavedProducts) {
            System.out.println(p.getName());
        }
    }

    @Test
    void deleteByIdMethod() {
        productRepository.deleteById(1L);
        List<Product> products = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteAllMethod() {
        productRepository.deleteAll();
    }

    @Test
    void deleteByEntityMethod() {
        Product product = productRepository.findById(53L).get();

        productRepository.delete(product);
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existByIdMethod() {
        Boolean isPresent = productRepository.existsById(122L);
        System.out.println(isPresent);
    }



}