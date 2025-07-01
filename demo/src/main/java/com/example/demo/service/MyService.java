package com.example.demo.service;

import com.example.demo.component.MyComponent;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private MyComponent myComponent ;

    public MyService(MyComponent myComponent) {
        System.out.println("MyService constructor");
        this.myComponent = myComponent;
    }

    public String getName() {
        System.out.println("myComponent.getMyComponentName has been called");
        return myComponent.getMyComponentName() ;
    }
}


