package dev.reso.practicing.service;

import dev.reso.practicing.dto.ClientDTO;
import dev.reso.practicing.dto.ClientMapper;
import dev.reso.practicing.model.Client;
import dev.reso.practicing.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Transactional(readOnly = true)
    public List<ClientDTO> getAll(){
        List<Client> list = clientRepository.findAll();
        return list.stream().map(clientMapper::map).toList();
    }

    @Transactional(readOnly = true)
    public ClientDTO getById(Long id){
        Optional<Client> client = clientRepository.findById(id);
        return client.map(clientMapper::map).orElse(null);
    }

    @Transactional
    public ClientDTO insert(ClientDTO obj){
        Client client = clientMapper.map(obj);
       client = clientRepository.save(client);
       return clientMapper.map(client);
    }

    @Transactional
    public void delete(Long id){
        clientRepository.deleteById(id);
    }

    @Transactional
    public ClientDTO update(ClientDTO clientDTO, Long id){
        Optional<Client> clientExists = clientRepository.findById(id);
        if(clientExists.isPresent()){
            Client client = clientMapper.map(clientDTO);
            client.setId(id);
            client = clientRepository.save(client);
            return clientMapper.map(client);
        }
        return null;
    }
}
