package com.kerberinc.serviceordersapi.domain.service;

import java.time.LocalDateTime;

import com.kerberinc.serviceordersapi.domain.model.ServiceOrder;
import com.kerberinc.serviceordersapi.domain.model.ServiceOrderStatus;
import com.kerberinc.serviceordersapi.domain.repository.ServiceOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManagementService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public ServiceOrder create(ServiceOrder serviceOrder) {
        serviceOrder.setStatus(ServiceOrderStatus.OPEN);
        serviceOrder.setStartDate(LocalDateTime.now());

        return serviceOrderRepository.save(serviceOrder);
    }

}