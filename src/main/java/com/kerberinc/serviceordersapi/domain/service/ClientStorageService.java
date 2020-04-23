package com.kerberinc.serviceordersapi.domain.service;

import com.kerberinc.serviceordersapi.domain.exception.BusinessLogicException;
import com.kerberinc.serviceordersapi.domain.model.Client;
import com.kerberinc.serviceordersapi.domain.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientStorageService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {
        Client storedClient = clientRepository.findByEmail(client.getEmail());

        if (storedClient != null && !storedClient.equals(client)) {
            throw new BusinessLogicException("Já existe um cliente cadastrado com este e-mail.");
        }

        return clientRepository.save(client);
    }

    public void delete(Long clientId) {
        clientRepository.deleteById(clientId);
    }

}