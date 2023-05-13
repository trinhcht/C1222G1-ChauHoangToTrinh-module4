package com.example.muon_sach.controller;
import com.example.muon_sach.exception.QuantityLowerThanZeroException;
import com.example.muon_sach.exception.WrongCodeException;
import com.example.muon_sach.model.Borrower;
import com.example.muon_sach.service.IBookService;
import com.example.muon_sach.service.IBorrowerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    private final IBookService bookService;

    private final IBorrowerService borrowerService;

    public BookController(IBookService bookService, IBorrowerService borrowerService) {
        this.bookService = bookService;
        this.borrowerService = borrowerService;
    }

    @GetMapping("books")
    public String findAllBook(Model model) {
        model.addAttribute("books", bookService.findAllBook());
        model.addAttribute("borrower", new Borrower());
        return "/list";
    }

    @PostMapping("/borrow-book")
    public String borrowBook(@ModelAttribute("borrower") Borrower borrower, RedirectAttributes redirectAttributes) throws  WrongCodeException {
        String code = borrowerService.codeBorrower();
        borrower.setCode(code);
        if (bookService.borrowerBook(borrower)){
            redirectAttributes.addFlashAttribute("mess", "Mượn sách thành công, " + "mã mượn sách là: " + code);
            redirectAttributes.addFlashAttribute("books", bookService.findAllBook());
        } else {
            redirectAttributes.addFlashAttribute("books", bookService.findAllBook());
            redirectAttributes.addFlashAttribute("mess", "Mượn sách thất bại");
        }
        return "/list";
    }

    @GetMapping("/return-book")
    public String returnBook(RedirectAttributes redirectAttributes, @RequestParam("code") String code) throws QuantityLowerThanZeroException {
        if (bookService.returnBook(code)) {
            redirectAttributes.addFlashAttribute("mess", "Trả sách thành công");
            redirectAttributes.addFlashAttribute("books", bookService.findAllBook());
        } else {
            redirectAttributes.addFlashAttribute("mess", "Trả sách không thành công");
            redirectAttributes.addFlashAttribute("books", bookService.findAllBook());
        }
        return "redirect:/books";

    }
}
