package com.example.deployExample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class SumController {

    @GetMapping("/sum")
    public int getRandomSum() {
        Random random = new Random();
        int num1 = random.nextInt(100); // Random number between 0 and 99
        int num2 = random.nextInt(100);
        return num1 + num2;
    }
}