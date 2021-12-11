package com.example.edelec.services.impl;

import com.example.edelec.entitys.Comments;
import com.example.edelec.repositories.CommentRepository;
import com.example.edelec.services.CommentService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comments createComment(Comments comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comments updateComment(Comments comment) {
           Comments  commentFromDb=commentRepository.findById(comment.getId())
                   .orElse(new Comments());
           commentFromDb.setContent(comment.getContent());
           commentFromDb.setVotes(comment.getVotes());
           commentFromDb.setDate(comment.getDate());
           commentFromDb.setUsuario(comment.getUsuario());
           return commentRepository.save(commentFromDb);

    }

    @Override
    public List<Comments> listComments() {
        return commentRepository.findAll();
    }
}

