package com.BAITAP28_10.__10.controller;

import com.BAITAP28_10.__10.entity.Category;
import com.BAITAP28_10.__10.service.ICategoryService;
import com.BAITAP28_10.__10.service.IFilesStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/function")
public class functionContoller {
    private final ICategoryService categoryService;
    private final IFilesStorageService storageService;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("category", new Category());
        return "add";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id") int id){
        categoryService.delete(categoryService.findById(id));
        return "redirect:/";
    }

    @PostMapping("/add_func")
    public String add_func(@RequestParam("name") String categoryName,
                           @RequestParam("status") int status,
                           @RequestParam("imageLink") String imageLink,
                           @RequestParam("image") MultipartFile file){
        Category category = new Category();
        category.setName(categoryName);
        category.setStatus(status);
        if(!imageLink.isEmpty()) category.setImage(imageLink);
        if(!file.isEmpty()){
            storageService.save(file);
            category.setImage(file.getOriginalFilename());
        }
        categoryService.save(category);
        return "redirect:/";
    }

    @GetMapping("edit")
    public String edit(@RequestParam(value = "id") int id, Model model){
        Category category = new Category();
        category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "edit";
    }
}
