package com.kerberinc.serviceordersapi.domain.service;

import java.time.OffsetDateTime;

import com.kerberinc.serviceordersapi.domain.exception.BusinessLogicException;
import com.kerberinc.serviceordersapi.domain.model.Client;
import com.kerberinc.serviceordersapi.domain.model.ServiceOrder;
import com.kerberinc.serviceordersapi.domain.model.ServiceOrderStatus;
import com.kerberinc.serviceordersapi.domain.repository.ClientRepository;
import com.kerberinc.serviceordersapi.domain.repository.ServiceOrderRepository;

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