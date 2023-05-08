package ss4.bai1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ss4.bai1.model.Product;
import ss4.bai1.service.IProductService;
import ss4.bai1.service.impl.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    IProductService iProductService = new ProductService();

    @GetMapping("")
    public String list(@RequestParam(defaultValue = "",required = false) String name, Model model) {
//        model.addAttribute("product", iProductService.listProductByName(name));
        model.addAttribute("product", iProductService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product) {
        iProductService.createProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        iProductService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/information/{id}")
    public String showInformation(@PathVariable int id, Model model) {
        model.addAttribute("productInform", iProductService.findById(id));
        return "/information";
    }

    @GetMapping("/update/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editProduct(int id, Product product) {
        iProductService.updateProduct(id, product);
        return "redirect:/product";
    }
}
