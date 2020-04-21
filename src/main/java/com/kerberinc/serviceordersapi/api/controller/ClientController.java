package com.kerberinc.serviceordersapi.api.controller;

import java.util.Arrays;
import java.util.List;

import com.kerberinc.serviceordersapi.domain.model.Client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/clients")
    public List<Client> index() {
        
        final var client1 = new Client();
		client1.setId(1L);
		client1.setName("João");
		client1.setPhone("34 99999-1111");
		client1.setEmail("joaodascouves@algaworks.com");

		final var client2 = new Client();
		client2.setId(2L);
		client2.setName("Maria");
		client2.setPhone("11 77777-1111");
		client2.setEmail("mariadasilva@algaworks.com");

		return Arrays.asList(client1, client2);
        
    }

}