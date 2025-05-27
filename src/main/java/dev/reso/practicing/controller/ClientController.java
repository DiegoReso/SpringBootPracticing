package dev.reso.practicing.controller;

import dev.reso.practicing.dto.ClientDTO;
import dev.reso.practicing.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation( summary = "GET ALL", description = "This route Finds All Clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client Found"),
            @ApiResponse(responseCode = "404", description = "Client Not Found")
    })
    public ResponseEntity <List<ClientDTO>> getAll(){
        List<ClientDTO> list = clientService.getAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Gets Client By ID" , description = "This route Gets one client by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client Found"),
            @ApiResponse(responseCode = "404", description = "Client Not Found")
    })
    public ResponseEntity<?> getById(@PathVariable Long id){
        ClientDTO client = clientService.getById(id);

        if(client != null){
            return ResponseEntity.ok().body(client);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
    }

    @Operation(summary = "Inserts Client", description ="this route inserts the client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client Created"),
            @ApiResponse(responseCode = "400", description = "Error creating client")
    })
    @PostMapping
    public ResponseEntity<ClientDTO>  insertClient(@RequestBody ClientDTO client){
       ClientDTO clientDTO =  clientService.insert(client);
       return ResponseEntity.status(HttpStatus.CREATED).body(clientDTO);
    }

    @Operation(summary = "Deletes Client by Id", description ="this route deletes the client by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Client Deleted"),
            @ApiResponse(responseCode = "404", description = "Client Not Found")
    })
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
    @Operation(summary = "Updates Client by ID", description = "This route updates the client by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client Found"),
            @ApiResponse(responseCode = "404", description = "Client Not Found")
    })
    public ResponseEntity<?>  updateClient(
            @Parameter(description = "User sends the data for update Client")
            @RequestBody ClientDTO client,
            @Parameter(description = "User sends the id on path")
            @PathVariable Long id){
        ClientDTO clientDTO =  clientService.update(client,id);
        if(clientDTO != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(clientDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
    }
}
