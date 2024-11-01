package com.BAITAP28_10.__10.controller;

import com.BAITAP28_10.__10.entity.Category;
import com.BAITAP28_10.__10.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class homeController {
    private final ICategoryService categoryService;
    @GetMapping("/")
    public String home(Model model){
        List<Category> list = categoryService.findAll();
        model.addAttribute("list", list);
        return "home";
    }

    @GetMapping("/pageable")
    public String pageable(Model model,
                           @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo){
        Page<Category> list = categoryService.findAll(pageNo);
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("list", list);
        return "pageable";
    }
}
