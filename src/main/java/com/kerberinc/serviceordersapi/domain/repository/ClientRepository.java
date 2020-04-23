package com.kerberinc.serviceordersapi.domain.repository;

import java.util.List;

import com.kerberinc.serviceordersapi.domain.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByName(String name);
    List<Client> findByNameContaining(String name);
    Client findByEmail(String email);

}