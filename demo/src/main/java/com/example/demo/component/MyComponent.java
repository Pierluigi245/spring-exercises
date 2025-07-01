package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    private final String myComponentName ;

    public MyComponent() {
        System.out.println("MyComponent constructor");
        this.myComponentName = "Pierluigi";
    }

    public String getMyComponentName() {
        return myComponentName;
    }
}
