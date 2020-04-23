package com.adrianokerber.serviceordersapi.domain.repository;

import com.adrianokerber.serviceordersapi.domain.model.ServiceOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {

}