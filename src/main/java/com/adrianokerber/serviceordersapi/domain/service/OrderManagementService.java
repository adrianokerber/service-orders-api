package com.adrianokerber.serviceordersapi.domain.service;

import java.time.OffsetDateTime;

import com.adrianokerber.serviceordersapi.domain.exception.BusinessLogicException;
import com.adrianokerber.serviceordersapi.domain.exception.EntityNotFoundException;
import com.adrianokerber.serviceordersapi.domain.model.Client;
import com.adrianokerber.serviceordersapi.domain.model.Comment;
import com.adrianokerber.serviceordersapi.domain.model.ServiceOrder;
import com.adrianokerber.serviceordersapi.domain.model.ServiceOrderStatus;
import com.adrianokerber.serviceordersapi.domain.repository.ClientRepository;
import com.adrianokerber.serviceordersapi.domain.repository.CommentRepository;
import com.adrianokerber.serviceordersapi.domain.repository.ServiceOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManagementService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CommentRepository commentRepository;

    public ServiceOrder create(ServiceOrder serviceOrder) {
        Client client = clientRepository.findById(serviceOrder.getClient().getId())
            .orElseThrow(() -> new BusinessLogicException("Cliente não encontrado"));

        serviceOrder.setClient(client);
        serviceOrder.setStatus(ServiceOrderStatus.OPEN);
        serviceOrder.setStartDate(OffsetDateTime.now());

        return serviceOrderRepository.save(serviceOrder);
    }

    public void finish(Long serviceOrderId) {
        ServiceOrder serviceOrder = getOrder(serviceOrderId);

        serviceOrder.finish();

        serviceOrderRepository.save(serviceOrder);
    }

    public Comment addComment(Long serviceOrderId, String description) {
        ServiceOrder serviceOrder = getOrder(serviceOrderId);

        Comment comment = new Comment();
        comment.setCreationDate(OffsetDateTime.now());
        comment.setDescription(description);
        comment.setServiceOrder(serviceOrder);

        return commentRepository.save(comment);
    }

    private ServiceOrder getOrder(Long serviceOrderId) {
        return serviceOrderRepository.findById(serviceOrderId)
            .orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não encontrada"));
    }

}