package com.example.bai2.controller;

import com.example.bai2.model.Category;
import com.example.bai2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.ManyToOne;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("")
    public String listCategory(Model model){
        List<Category> categorieList = iCategoryService.findAll();
        model.addAttribute("categoryList",categorieList);
        return "category/list_category";
    }
    @GetMapping("/add")
    public String create(Model model){
        model.addAttribute("category",new Category());
        return "category/create_category";
    }
    @PostMapping("/save")
    public String save(Category category, RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("smg","successful!");
        return "redirect:/category";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "category/edit_category";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        iCategoryService.update(category);
        redirectAttributes.addFlashAttribute("smg", "Update successful!");
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/delete_category";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        iCategoryService.delete(category.getId());
        redirectAttributes.addFlashAttribute("smg","Delete successful!");
        return "redirect:/category";
    }
}
