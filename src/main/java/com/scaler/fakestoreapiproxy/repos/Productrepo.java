package com.scaler.fakestoreapiproxy.repos;

import com.scaler.fakestoreapiproxy.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface Productrepo extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long id);
    Optional<Product>findByTitle(String title);
    List<Product> findByTitleAndDescription(String Description, String title);
    Product save(Product product);
}
