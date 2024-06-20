package com.scaler.fakestoreapiproxy.repos;

import com.scaler.fakestoreapiproxy.Models.Category;
import com.scaler.fakestoreapiproxy.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Categoryrepo extends JpaRepository<Category,Long>{
    @Override
    Optional<Category> findById(Long id);

    Optional<Category>findBycategory(String categoryentered);
}
