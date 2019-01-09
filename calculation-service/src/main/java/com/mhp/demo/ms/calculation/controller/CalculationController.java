package com.mhp.demo.ms.calculation.controller;

import com.mhp.demo.common.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fjiang.
 */
@RestController
@RequestMapping("/calculation")
public class CalculationController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/calculate")
    public String calculate() {
        int firstOperand = restTemplate.getForObject("http://operand-service:8081/operand/produce", Integer.class);
        int secondOperand = restTemplate.getForObject("http://operand-service:8081/operand/produce", Integer.class);
        String operator = restTemplate.getForObject("http://operator-service:8082/operator/produce", String.class);
        return firstOperand + " "+ operator + " "+ secondOperand + " = "getResult(firstOperand, secondOperand, operator);
    }

    private int getResult(int firstOperand, int secondOperand, String operator) {
        if (operator.equals(Operator.ADD.name())) {
            return firstOperand + secondOperand;
        } else if (operator.equals(Operator.SUBSTRACT.name())) {
            return firstOperand - secondOperand;
        } else if (operator.equals(Operator.MULTIPLY.name())) {
            return firstOperand * secondOperand;
        } else {
            throw new RuntimeException(String.format("Unknown operator %s", operator));
        }
    }

}
