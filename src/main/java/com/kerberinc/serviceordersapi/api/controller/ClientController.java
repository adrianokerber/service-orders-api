package com.kerberinc.serviceordersapi.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kerberinc.serviceordersapi.domain.model.Client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@PersistenceContext
	private EntityManager manager;

    @GetMapping("/clients")
    public List<Client> index() {
		return manager.createQuery("from Client", Client.class)
			.getResultList();
    }

}