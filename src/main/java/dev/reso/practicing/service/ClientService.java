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

    @Transactional
    public List<Client> getAll(){
        List<Client> list = clientRepository.findAll();
        return list;
    }

    @Transactional
    public Client getById(Long id){
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }
}
