package com.sharp.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharp.sharp.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}
