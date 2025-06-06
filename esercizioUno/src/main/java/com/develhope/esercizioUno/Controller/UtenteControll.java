package com.develhope.esercizioUno.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtenteControll {
    @GetMapping("v1/ciao")
    public String saluto (@RequestParam (required = false,defaultValue = "Giuseppe") String nome, @RequestParam (required = false,defaultValue = "Lombardia")  String provincia) {
        return "Ciao " + nome + " com'è il tempo in " + provincia + "?" ;

    }
}
