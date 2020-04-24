package com.adrianokerber.serviceordersapi.api.controller;

import javax.validation.Valid;

import com.adrianokerber.serviceordersapi.api.model.CommentInput;
import com.adrianokerber.serviceordersapi.api.model.CommentModel;
import com.adrianokerber.serviceordersapi.domain.model.Comment;
import com.adrianokerber.serviceordersapi.domain.service.OrderManagementService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    private CommentModel toModel(Comment comment) {
        return modelMapper.map(comment, CommentModel.class);
    }

}