package com.kerberinc.serviceordersapi.api.controller;

import java.util.List;

import com.kerberinc.serviceordersapi.domain.model.Client;
import com.kerberinc.serviceordersapi.domain.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> index() {
		return clientRepository.findAll();
    }

}