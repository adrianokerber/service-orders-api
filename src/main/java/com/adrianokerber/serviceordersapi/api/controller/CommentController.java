package com.adrianokerber.serviceordersapi.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.adrianokerber.serviceordersapi.api.model.CommentInput;
import com.adrianokerber.serviceordersapi.api.model.CommentModel;
import com.adrianokerber.serviceordersapi.domain.exception.EntityNotFoundException;
import com.adrianokerber.serviceordersapi.domain.model.Comment;
import com.adrianokerber.serviceordersapi.domain.model.ServiceOrder;
import com.adrianokerber.serviceordersapi.domain.repository.ServiceOrderRepository;
import com.adrianokerber.serviceordersapi.domain.service.OrderManagementService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-orders/{serviceOrderId}/comments")
public class CommentController {

    @Autowired
    private OrderManagementService orderManagementService;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentModel addComment(
        @PathVariable Long serviceOrderId,
        @Valid @RequestBody CommentInput commentInput
    ) {
        Comment comment = orderManagementService.addComment(serviceOrderId, commentInput.getDescription());

        return toModel(comment);
    }

    @GetMapping
    public List<CommentModel> list(@PathVariable Long serviceOrderId) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(serviceOrderId)
            .orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não encontrada"));

        return toCollectionModel(serviceOrder.getComments());
    }

    private CommentModel toModel(Comment comment) {
        return modelMapper.map(comment, CommentModel.class);
    }

    private List<CommentModel> toCollectionModel(List<Comment> comments) {
        return comments.stream()
            .map(comment -> toModel(comment))
            .collect(Collectors.toList());
    }

}