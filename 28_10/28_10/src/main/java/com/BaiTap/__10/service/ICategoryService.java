package com.BaiTap.__10.service;

import com.BaiTap.__10.entity.Category;
import com.BaiTap.__10.repository.ICategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService{
    Page<Category> findByNameContaining(String keyword, Pageable page);
    Page<Category> findAll(Pageable paging);
    long count();
}
