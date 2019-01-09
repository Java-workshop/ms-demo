package com.mhp.demo.ms.operand.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by fjiang.
 */
@RestController
@RequestMapping("/operand")
public class OperandController {

    @GetMapping("/produce")
    public int produce() {
        return new Random().nextInt(10);

    }
}
