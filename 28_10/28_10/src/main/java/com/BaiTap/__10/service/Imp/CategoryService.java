package com.BaiTap.__10.service.Imp;

import com.BaiTap.__10.entity.Category;
import com.BaiTap.__10.repository.ICategoryRepository;
import com.BaiTap.__10.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Page<Category> findByNameContaining(String keyword, Pageable page) {
        return categoryRepository.findByNameContaining(keyword, page);
    }

    @Override
    public Page<Category> findAll(Pageable paging) {
        return categoryRepository.findAll(paging);
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }
}
