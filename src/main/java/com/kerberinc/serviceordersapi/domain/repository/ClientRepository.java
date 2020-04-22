package com.kerberinc.serviceordersapi.domain.repository;

import com.kerberinc.serviceordersapi.domain.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}