package dev.reso.practicing.controller;

import dev.reso.practicing.dto.ClientDTO;
import dev.reso.practicing.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity <List<ClientDTO>> getAll(){
        List<ClientDTO> list = clientService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        ClientDTO client = clientService.getById(id);

        if(client != null){
            return ResponseEntity.ok(client);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
    }

    @PostMapping
    public ResponseEntity<ClientDTO>  insertClient(@RequestBody ClientDTO client){
       ClientDTO clientDTO =  clientService.insert(client);
       return ResponseEntity.status(HttpStatus.CREATED).body(clientDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){

        if(clientService.getById(id) != null){
            clientService.delete(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com id " + id + " nao encontrado!");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?>  updateClient(@RequestBody ClientDTO client, @PathVariable Long id){
        ClientDTO clientDTO =  clientService.update(client,id);
        if(clientDTO != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(clientDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
    }
}
