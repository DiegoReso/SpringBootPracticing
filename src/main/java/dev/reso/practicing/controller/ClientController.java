package dev.reso.practicing.controller;

import dev.reso.practicing.dto.ClientDTO;
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
    public ResponseEntity <List<ClientDTO>> getAll(){
        List<ClientDTO> list = clientService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable Long id){
        ClientDTO client = clientService.getById(id);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping
    public ResponseEntity<ClientDTO>  insertClient(@RequestBody ClientDTO client){
       ClientDTO clientDTO =  clientService.insert(client);
       return ResponseEntity.ok().body(clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.delete(id);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@RequestBody ClientDTO client, @PathVariable Long id){
        return clientService.update(client,id);
    }
}
