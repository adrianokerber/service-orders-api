package com.adrianokerber.serviceordersapi.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.adrianokerber.serviceordersapi.api.model.ServiceOrderModel;
import com.adrianokerber.serviceordersapi.domain.model.ServiceOrder;
import com.adrianokerber.serviceordersapi.domain.repository.ServiceOrderRepository;
import com.adrianokerber.serviceordersapi.domain.service.OrderManagementService;

import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceOrderModel create(@Valid @RequestBody ServiceOrder serviceOrder) {
        return toModel(orderManagementService.create(serviceOrder));
    }

    @GetMapping
    public List<ServiceOrderModel> list() {
        return toCollectionModel(serviceOrderRepository.findAll());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<ServiceOrderModel> find(@PathVariable Long orderId) {
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(orderId);

        if (serviceOrder.isPresent()) {
            ServiceOrderModel serviceOrderModel = toModel(serviceOrder.get());

            return ResponseEntity.ok(serviceOrderModel);
        }

        return ResponseEntity.notFound().build();
    }

    private ServiceOrderModel toModel(ServiceOrder serviceOrder) {
        return modelMapper.map(serviceOrder, ServiceOrderModel.class);
    }

    private List<ServiceOrderModel> toCollectionModel(List<ServiceOrder> serviceOrders) {
        return serviceOrders.stream()
            .map(serviceOrder -> toModel(serviceOrder))
            .collect(Collectors.toList());
    }

}