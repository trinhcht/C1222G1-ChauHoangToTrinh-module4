package ss3.ss3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ss3.ss3.model.MailBox;
import ss3.ss3.service.impl.MailBoxService;

@Controller
public class MailBoxController {
    private final MailBoxService mailBoxService;

    public MailBoxController(MailBoxService mailBoxService) {
        this.mailBoxService = mailBoxService;
    }

    @GetMapping("/index")
    String index(Model model, @RequestParam(name = "language", required = false) String language,
                 @RequestParam(name = "pageSize", required = false) Integer pageSize,
                 @RequestParam(name = "spamsFilter", required = false) boolean spamsFilter,
                 @RequestParam(name = "signature", required = false) String signature) {
        MailBox mailBox = new MailBox(language, pageSize, spamsFilter, signature);
        model.addAttribute("mailBox", mailBox);
        return "/index";
    }
    @GetMapping("/update")
    String showPageUpdate(Model model) {
        model.addAttribute("mailBox", new MailBox());
        model.addAttribute("languages", mailBoxService.languages());
        model.addAttribute("pageSizes", mailBoxService.pageSizes());
        return "/update";
    }
}