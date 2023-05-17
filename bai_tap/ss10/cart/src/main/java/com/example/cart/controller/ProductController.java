package com.example.cart.controller;

import com.example.cart.dto.ProductDTO;
import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    private Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public String showProduct(Model model) {
        model.addAttribute("productList", productService.findAllCart());
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail (@RequestParam Long id, Model model) {
        model.addAttribute("productList", productService.findById(id));
        return "/detail";
    }

//    @GetMapping("/list")
//    public String showShop (Model model) {
//        model.addAttribute("productDTOList", productService.findAll());
//        return "/list";
//    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/product";
    }

    @GetMapping("/decrease/{id}")
    public String removeFromCart (@PathVariable Long id,
                                  @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error";
        }
            cart.removeProduct(productOptional.get());
            return "redirect:/cart";
    }
}