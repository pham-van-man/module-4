package org.example.bai_tap_2.service;

import org.example.bai_tap_2.model.Calculator;
import org.springframework.stereotype.Service;

@Service
public class ServiceCalculatorImpl implements ServiceCalculator {
    @Override
    public double result(Calculator calculator) {
        switch (calculator.getOperation()) {
            case "+":
                return calculator.getA() + calculator.getB();
            case "-":
                return calculator.getA() - calculator.getB();
            case "*":
                return calculator.getA() * calculator.getB();
            default:
                return calculator.getA() / calculator.getB();
        }
    }
}
