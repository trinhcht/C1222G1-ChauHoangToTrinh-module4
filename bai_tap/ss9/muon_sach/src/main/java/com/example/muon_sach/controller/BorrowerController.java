package com.example.muon_sach.controller;

import com.example.muon_sach.service.IBorrowerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BorrowerController {
    private final IBorrowerService borrowerService;

    public BorrowerController(IBorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @GetMapping("/borrower")
    public String findAllBorrower(Model model) {
        model.addAttribute("listBorrower", borrowerService.findAllBorrower());
        return "/borrower";
    }
}
