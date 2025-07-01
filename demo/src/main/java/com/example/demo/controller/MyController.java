package com.example.demo.controller;

import com.example.demo.component.MyComponent;
import com.example.demo.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private MyService myService ;

    public MyController(MyService myService) {
        this.myService = myService;
        System.out.println("myController constructor");
    }

    @GetMapping("/getName")
    public String getNameService () {
        System.out.println("MyService.getName has been called");
        return myService.getName() ;
    }

    @GetMapping
    public String stampaMessaggio() {
        return "benvenuto" ;
    }
}
