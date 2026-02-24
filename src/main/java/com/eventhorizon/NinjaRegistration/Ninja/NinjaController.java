package com.eventhorizon.NinjaRegistration.Ninja;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boasVindas")
    public String boasVindas() {return "Boas vindas ao controller ninja";}
}
