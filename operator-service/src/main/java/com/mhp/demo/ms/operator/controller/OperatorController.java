package com.mhp.demo.ms.operator.controller;

import com.mhp.demo.common.Operator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by fjiang.
 */
@RestController
@RequestMapping("/operator")
public class OperatorController {

    @GetMapping("/produce")
    public String produce() {
        int size = Operator.values().length;
        int random = new Random().nextInt(size);
        return Operator.values()[random].name();
    }
}
