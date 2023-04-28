package ss2.bai2.service.impl;

import org.springframework.stereotype.Service;
import ss2.bai2.service.ICalculatorService;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double performCalculator(String calculate, double firstNumber, double secondNumber) {

        switch (calculate){
            case "Addition":
                return firstNumber + secondNumber;
            case "Subtraction":
                return firstNumber - secondNumber;
            case "Multiplication":
                return firstNumber * secondNumber;
            case "Division":
                if (secondNumber != 0){
                    return firstNumber / secondNumber;
                }else {
                    return 0;
                }
            default:
        }
        return 0;
    }
}
