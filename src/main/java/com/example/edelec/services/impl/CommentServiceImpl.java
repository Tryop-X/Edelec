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
           Comments  commentFromDb=commentRepository.findById(comment.getIdComentario())
                   .orElse(new Comments());
           commentFromDb.setContenido(comment.getContenido());
           commentFromDb.setVotes(comment.getVotes());
           commentFromDb.setTiempo(comment.getTiempo());
           commentFromDb.setUser(comment.getUser());
           commentFromDb.setUniversidad(comment.getUniversidad());
           return commentRepository.save(comment);

    }

    @Override
    public List<Comments> listComments() {
        return commentRepository.findAll();
    }
}

