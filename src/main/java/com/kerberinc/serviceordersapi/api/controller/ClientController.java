package com.kerberinc.serviceordersapi.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.kerberinc.serviceordersapi.domain.model.Client;
import com.kerberinc.serviceordersapi.domain.repository.ClientRepository;
import com.kerberinc.serviceordersapi.domain.service.ClientStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ClientStorageService clientStorageService;

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

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client add(@Valid @RequestBody Client client) {
		return clientStorageService.save(client);
	}

	@PutMapping("/{clientId}")
	public ResponseEntity<Client> update(
		@PathVariable Long clientId,
		@Valid @RequestBody Client client
	) {
		
		if (!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}

		client.setId(clientId);
		client = clientStorageService.save(client);

		return ResponseEntity.ok(client);

	}

	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> delete(@PathVariable Long clientId) {

		if (!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}

		clientStorageService.delete(clientId);

		return ResponseEntity.noContent().build();

	}

}