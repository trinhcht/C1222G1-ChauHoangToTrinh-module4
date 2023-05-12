package com.example.muon_sach.controller;

import com.example.muon_sach.dto.BookDTO;
import com.example.muon_sach.exception.QuantityLowerThanZeroException;
import com.example.muon_sach.model.Borrower;
import com.example.muon_sach.service.IBookDTOService;
import com.example.muon_sach.service.IBookService;
import com.example.muon_sach.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/borrow_book")
public class BookController {
    @Autowired
    @Qualifier("bookDTOService")
    private IBookDTOService iBookDTOService;
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowerService iBorrowerService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("bookDTOList", iBookDTOService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        model.addAttribute("borrowerList", iBorrowerService.findAll());
        model.addAttribute("bookDTOList", new BookDTO());
        return "/create";
    }

    @PostMapping("/create")
    public String performCreate(@ModelAttribute BookDTO bookDTO) {
        iBookDTOService.save(bookDTO);
        return "redirect:/borrow_book";
    }

    @GetMapping("/update/{idBookDTO")
    public String showUpdate(@PathVariable int idBookDTO, Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        model.addAttribute("borrowerList", iBorrowerService.findAll());
        model.addAttribute("bookCodeList", iBookDTOService.findById(idBookDTO));
        return "update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute BookDTO bookDTO) {
        iBookDTOService.save(bookDTO);
        return "redirect:/borrow_book";
    }

    @GetMapping("/delete")
    public String performDelete(@RequestParam(required = false) Integer deleteId) {
        iBookDTOService.delete(deleteId);
        return "redirect:/borrow_book";
    }

    @GetMapping("/borrow")
    public String borrow(@RequestParam(name = "idBook") Integer id, @RequestParam(name = "idBorrower") Integer idBorrower, RedirectAttributes redirectAttributes) throws QuantityLowerThanZeroException {
        Borrower borrower = iBorrowerService.findById(idBorrower);
        if (borrower == null) {
            redirectAttributes.addAttribute("msg", "Borrower not found");
            return "redirect:/list";
        }else if (iBookService.findById(id).getQuantity()==0){
            throw new QuantityLowerThanZeroException();
        }else {
            iBookService.borrow(id,idBorrower);
        }
        return "redirect:/borrow_book";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam(required = false) Integer dtoBook) {
        return "redirect:/borrow_book";
    }
    @ExceptionHandler(Exception.class)
    public String handel(){
        return "/error";
    }
}
