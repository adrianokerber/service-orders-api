package com.adrianokerber.serviceordersapi.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.adrianokerber.serviceordersapi.api.model.ClientInput;
import com.adrianokerber.serviceordersapi.api.model.ClientModel;
import com.adrianokerber.serviceordersapi.domain.model.Client;
import com.adrianokerber.serviceordersapi.domain.repository.ClientRepository;
import com.adrianokerber.serviceordersapi.domain.service.ClientStorageService;

import org.modelmapper.ModelMapper;
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

	@Autowired
	private ModelMapper modelMapper;

    @GetMapping
    public List<ClientModel> list() {
		return toCollectionModel(clientRepository.findAll());
	}
	
	@GetMapping("/{clientId}")
	public ResponseEntity<ClientModel> find(@PathVariable Long clientId) {
		Optional<Client> client = clientRepository.findById(clientId);

		if (client.isPresent()) {
			ClientModel clientModel = toModel(client.get());

			return ResponseEntity.ok(clientModel);
		}
		
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClientModel create(@Valid @RequestBody ClientInput clientInput) {
		Client client = toEntity(clientInput);

		return toModel(clientStorageService.create(client));
	}

	@PutMapping("/{clientId}")
	public ResponseEntity<ClientModel> update(
		@PathVariable Long clientId,
		@Valid @RequestBody ClientInput clientInput
	) {
		
		if (!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}

		Client client = toEntity(clientInput);
		client.setId(clientId);
		ClientModel clientModel = toModel(clientStorageService.create(client));

		return ResponseEntity.ok(clientModel);

	}

	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> delete(@PathVariable Long clientId) {

		if (!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}

		clientStorageService.delete(clientId);

		return ResponseEntity.noContent().build();

	}

	private ClientModel toModel(Client client) {
		return modelMapper.map(client, ClientModel.class);
	}

	private List<ClientModel> toCollectionModel(List<Client> clients) {
		return clients.stream()
			.map(client -> toModel(client))
			.collect(Collectors.toList());
	}

	private Client toEntity(ClientInput clientInput) {
		return modelMapper.map(clientInput, Client.class);
	}

}