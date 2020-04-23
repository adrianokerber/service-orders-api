package com.kerberinc.serviceordersapi.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.kerberinc.serviceordersapi.domain.model.ServiceOrder;
import com.kerberinc.serviceordersapi.domain.repository.ServiceOrderRepository;
import com.kerberinc.serviceordersapi.domain.service.OrderManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-orders")
public class ServiceOrderController {

    @Autowired
    private OrderManagementService orderManagementService;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceOrder create(@Valid @RequestBody ServiceOrder serviceOrder) {
        return orderManagementService.create(serviceOrder);
    }

    @GetMapping
    public List<ServiceOrder> list() {
        return serviceOrderRepository.findAll();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<ServiceOrder> find(@PathVariable Long orderId) {
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(orderId);

        if (serviceOrder.isPresent()) {
            return ResponseEntity.ok(serviceOrder.get());
        }

        return ResponseEntity.notFound().build();
    }

}