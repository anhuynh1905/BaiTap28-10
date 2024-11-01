package com.BAITAP28_10.__10.service.Impl;

import com.BAITAP28_10.__10.entity.Category;
import com.BAITAP28_10.__10.repository.CategoryRepository;
import com.BAITAP28_10.__10.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;


    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 2);
        return categoryRepository.findAll(pageable);
    }

}
