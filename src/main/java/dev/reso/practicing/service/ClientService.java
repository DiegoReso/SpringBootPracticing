package dev.reso.practicing.service;

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

    @Transactional(readOnly = true)
    public List<Client> getAll(){
        List<Client> list = clientRepository.findAll();
        return list;
    }

    @Transactional(readOnly = true)
    public Client getById(Long id){
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

    @Transactional
    public Client insert(Client obj){
       return clientRepository.save(obj);
    }

    @Transactional
    public void delete(Long id){
        clientRepository.deleteById(id);
    }

    @Transactional
    public Client update(Client client, Long id){
        if(clientRepository.existsById(id)){
            client.setId(id);
            return clientRepository.save(client);
        }
        return null;
    }
}
