package com.adrianokerber.serviceordersapi.domain.service;

import java.time.OffsetDateTime;

import com.adrianokerber.serviceordersapi.domain.exception.BusinessLogicException;
import com.adrianokerber.serviceordersapi.domain.model.Client;
import com.adrianokerber.serviceordersapi.domain.model.ServiceOrder;
import com.adrianokerber.serviceordersapi.domain.model.ServiceOrderStatus;
import com.adrianokerber.serviceordersapi.domain.repository.ClientRepository;
import com.adrianokerber.serviceordersapi.domain.repository.ServiceOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManagementService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ClientRepository clientRepository;

    public ServiceOrder create(ServiceOrder serviceOrder) {
        Client client = clientRepository.findById(serviceOrder.getClient().getId())
            .orElseThrow(() -> new BusinessLogicException("Cliente não encontrado"));

        serviceOrder.setClient(client);
        serviceOrder.setStatus(ServiceOrderStatus.OPEN);
        serviceOrder.setStartDate(OffsetDateTime.now());

        return serviceOrderRepository.save(serviceOrder);
    }

}