package com.example.bai2.controller;

import com.example.bai2.dto.SongDTO;
import com.example.bai2.model.Song;
import com.example.bai2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("songList", iSongService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute SongDTO songDTO,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("songDTO", songDTO);
            return "/create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            iSongService.create(song);
            redirectAttributes.addAttribute("msg", "Create successful");
            return "redirect:/song";
        }
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("songDTO", iSongService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute SongDTO songDTO,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("songDTO", songDTO);
            return "update";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            iSongService.update(song);
            redirectAttributes.addFlashAttribute("msg", "Update successful");
            return "redirect:/song";
        }
    }
}
