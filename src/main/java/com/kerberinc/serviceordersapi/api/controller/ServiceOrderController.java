package com.kerberinc.serviceordersapi.api.controller;

import com.kerberinc.serviceordersapi.domain.model.ServiceOrder;
import com.kerberinc.serviceordersapi.domain.service.OrderManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceOrder criate(@RequestBody ServiceOrder serviceOrder) {
        return orderManagementService.create(serviceOrder);
    }

}