package com.develhope.esercizioUno.Controller;

import jakarta.websocket.server.PathParam;
import model.UserExDue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class esercizioDueController {

    @GetMapping("v2/ciao/{provincia}")
        public UserExDue salutare(
        @PathVariable("provincia") String provincia,
        @RequestParam(required = false,defaultValue = "Giuseppe") String nome) {


            String saluto =  "Ciao " + nome + " com'è il tempo in " + provincia + "?" ;
            return new UserExDue(nome , provincia , saluto);

        }


}
