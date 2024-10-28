package com.BaiTap.__10.repository;

import com.BaiTap.__10.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer>{
    Page<Category> findByNameContaining(String keyword, Pageable page);
}
