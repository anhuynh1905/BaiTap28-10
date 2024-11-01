package com.BAITAP28_10.__10.service;

import com.BAITAP28_10.__10.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {
    void save(Category category);
    void delete(Category category);
    Category findById(int id);
    List<Category> findAll();
    Page<Category> findAll(Integer pageNo);
}
