package dev.reso.practicing.controller;


import dev.reso.practicing.model.Client;
import dev.reso.practicing.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id){
        Client client = clientService.getById(id);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping
    public Client insertClient(@RequestBody Client client){
       return clientService.insert(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.delete(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable Long id){
        return clientService.update(client,id);
    }
}
