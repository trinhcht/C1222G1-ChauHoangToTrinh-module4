package ss2.bai2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ss2.bai2.service.ICalculatorService;
import ss2.bai2.service.impl.CalculatorService;

@Controller
public class Calculator {
    ICalculatorService iCalculatorService = new CalculatorService();

    @GetMapping("calculator")
    public String calculator(@RequestParam(required = false) Double firstNumber, Double secondNumber, String calculate, Model model) {
        if (firstNumber == null & secondNumber == null) {
            return "/list";
        }
        double result = iCalculatorService.performCalculator(calculate, firstNumber, secondNumber);
        model.addAttribute("result", result);
        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("secondNumber", secondNumber);
        model.addAttribute("calculate", calculate);
        return "/list";
    }
}
