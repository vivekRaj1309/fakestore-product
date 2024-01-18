package com.fakestore.fakestoreapi.repositories;

import com.fakestore.fakestoreapi.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepositories extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);
}
