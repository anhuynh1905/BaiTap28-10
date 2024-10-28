package com.BaiTap.__10.controller;

import com.BaiTap.__10.entity.Category;
import com.BaiTap.__10.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public String search(ModelMap model,
                         @RequestParam(name="name",required = false) String name,
                         @RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size) {
        int count = (int) categoryService.count();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Pageable pageable = PageRequest.of(currentPage-1, pageSize, Sort.by("name"));
        Page<Category> resultPage = null;
        if(StringUtils.hasText(name)) {
            resultPage = categoryService.findByNameContaining(name,pageable);
            model.addAttribute("name",name);
        }else {
            resultPage = categoryService.findAll(pageable);
        }
        int totalPages = resultPage.getTotalPages();
        if(totalPages > 0) {
            int start = Math.max(1, currentPage-2);
            int end = Math.min(currentPage + 2, totalPages);
            if(totalPages > count) {
                if(end == totalPages) start = end - count;
                else if (start == 1) end = start + count;
            }
            List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("categoryPage",resultPage);
        return "admin/category/list";
    }

    @GetMapping("/save_edit")
    public String save_edit(){
        return "Save_Edit";
    }
}
