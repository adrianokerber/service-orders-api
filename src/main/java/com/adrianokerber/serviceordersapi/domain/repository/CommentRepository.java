package com.adrianokerber.serviceordersapi.domain.repository;

import com.adrianokerber.serviceordersapi.domain.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}