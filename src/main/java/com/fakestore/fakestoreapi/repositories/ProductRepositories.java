package com.fakestore.fakestoreapi.repositories;

import com.fakestore.fakestoreapi.models.Product;
import com.fakestore.fakestoreapi.repositories.projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepositories extends JpaRepository<Product, Long> {
    List<Product> findAllByTitleContaining(String title);
    @Query(value = "SELECT p.title, p.description, c.name FROM product p JOIN category c ON p.category_id = c.id", nativeQuery = true)
    List<ProductProjection> getAllProductDetails();
}
