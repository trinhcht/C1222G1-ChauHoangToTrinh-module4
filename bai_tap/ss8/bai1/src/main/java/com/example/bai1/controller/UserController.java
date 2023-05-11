package com.example.bai1.controller;

import com.example.bai1.dto.UserDTO;
import com.example.bai1.model.User;
import com.example.bai1.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("userList", iUserService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "create";
    }
    @PostMapping("/create")
    public String createForm(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        iUserService.create(user);
        redirectAttributes.addFlashAttribute("msg", "msg.createSuccess");
        return "redirect:/user";
    }
}
