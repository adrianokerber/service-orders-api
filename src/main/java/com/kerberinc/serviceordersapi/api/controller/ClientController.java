package com.kerberinc.serviceordersapi.api.controller;

import java.util.List;
import java.util.Optional;

import com.kerberinc.serviceordersapi.domain.model.Client;
import com.kerberinc.serviceordersapi.domain.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

    @GetMapping
    public List<Client> index() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/{clientId}")
	public ResponseEntity<Client> getClient(@PathVariable Long clientId) {
		Optional<Client> client = clientRepository.findById(clientId);

		if (client.isPresent()) {
			return ResponseEntity.ok(client.get());
		}
		
		return ResponseEntity.notFound().build();
	}

}