package com.example.cinema.controller;

import com.example.cinema.dto.SuatChieuDTO;
import com.example.cinema.model.SuatChieu;
import com.example.cinema.service.IPhimService;
import com.example.cinema.service.ISuatChieuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cinema")
public class SuatChieuController {
    @Autowired
    private ISuatChieuService iSuatChieuService;
    @Autowired
    private IPhimService iPhimService;

    @GetMapping()
    public String findAllSuatChieu(Model model) {
        model.addAttribute("suatChieu", iSuatChieuService.findAllSuatChieu());
        model.addAttribute("phim", iPhimService.getAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreateSuatChieu(Model model) {
        model.addAttribute("SuatChieuDTO", new SuatChieuDTO());
        model.addAttribute("phimList",iPhimService.getAll());
        return "/create";
    }

    @PostMapping("/save")
    public String savePhim(@Validated @ModelAttribute(value = "SuatChieuDTO") SuatChieuDTO suatChieuDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("SuatChieuDTO", new SuatChieuDTO());
            model.addAttribute("phimList",iPhimService.getAll());
            return "/create";
        } else {
            SuatChieu suatChieu = new SuatChieu();
            BeanUtils.copyProperties( suatChieuDTO,suatChieu);
            iSuatChieuService.createSuatChieu(suatChieu);
            redirectAttributes.addFlashAttribute("message", "New add success!");
        }
        return "redirect:/cinema";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable String id, Model model) {
        model.addAttribute("suatChieu", iSuatChieuService.findAllSuatChieu());
//        model.addAttribute("suatChieu",iPhimService.findAll)
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute SuatChieu suatChieu, RedirectAttributes redirectAttributes) {
        iSuatChieuService.edit(suatChieu);
        redirectAttributes.addFlashAttribute("message", "Update success!");
        return "redirect:/cinema";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("suatChieu", iSuatChieuService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute SuatChieuDTO suatChieuDTO, RedirectAttributes redirectAttributes) {
        iSuatChieuService.delete(suatChieuDTO.getId());
        redirectAttributes.addFlashAttribute("message", "Delete success!");
        return "redirect:/cinema";
    }
}
