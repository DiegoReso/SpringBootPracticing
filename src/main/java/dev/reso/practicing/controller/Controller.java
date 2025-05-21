package dev.reso.practicing.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seeit")
public class Controller {


    @GetMapping
    public String mostrarString(){
        return "Oinn";
    }

}
