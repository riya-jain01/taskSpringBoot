package com.products.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.products.app.modal.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
