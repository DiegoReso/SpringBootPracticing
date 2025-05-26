package dev.reso.practicing.dto;

import dev.reso.practicing.model.Client;


import dev.reso.practicing.model.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientMapper {


    public Client map(ClientDTO clientDTO){
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setAge(clientDTO.getAge());
        client.setEmail(clientDTO.getEmail());
        client.setRank(clientDTO.getRank());
        client.setMissions(clientDTO.getMissions());

        return client;
    }

    public ClientDTO map(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setAge(client.getAge());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setRank(client.getRank());
        clientDTO.setMissions(client.getMissions());

        return clientDTO;
    }
}
