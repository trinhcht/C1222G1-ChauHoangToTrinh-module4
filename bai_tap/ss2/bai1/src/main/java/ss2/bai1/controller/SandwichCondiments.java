package ss2.bai1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("save")
public class SandwichCondiments {
    @GetMapping("")
    public String save(@RequestParam(required = false) String [] condiments, Model model ){
        if(condiments==null){
            model.addAttribute("condimentsList","");
            return "list";
        }
        model.addAttribute("condimentsList", Arrays.toString(condiments));
        return "list";
    }
}
