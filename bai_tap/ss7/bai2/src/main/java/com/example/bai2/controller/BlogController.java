package com.example.bai2.controller;
import com.example.bai2.model.Blog;
import com.example.bai2.service.IBlogService;
import com.example.bai2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showListBlog(@PageableDefault(value = 2, sort = "id", direction = Sort.Direction.DESC)
                               Pageable pageable, @RequestParam(value = "search",defaultValue = "")
                               String search, Model model){
        model.addAttribute("blogList", iBlogService.findByTitle(search, pageable));
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("search", search);
        return "blog/list";
    }
    @GetMapping("/dto")
    public String showListDto(Model model){
        model.addAttribute("dtoList",iBlogService.showListDto());
        return "blog/dto";
    }
    @GetMapping("/add")
    public String create(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "blog/create";
    }
    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("smg","Add new successful!");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "blog/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("smg","Update successful!");
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "blog/delete";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.delete(blog.getId());
        redirectAttributes.addFlashAttribute("smg","Delete successful!");
        return "redirect:/";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "blog/view";
    }
}

