package dev.reso.practicing.controller;


import dev.reso.practicing.model.Client;
import dev.reso.practicing.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity <List<Client>> getAll(){
        List<Client> list = clientService.getAll();
        return ResponseEntity.ok().body(list);
    }


}
