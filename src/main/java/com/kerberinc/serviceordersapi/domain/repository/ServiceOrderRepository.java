package com.kerberinc.serviceordersapi.domain.repository;

import com.kerberinc.serviceordersapi.domain.model.ServiceOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {

}