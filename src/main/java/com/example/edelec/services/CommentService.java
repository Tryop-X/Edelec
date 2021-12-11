package com.example.edelec.services;


import com.example.edelec.entities.Comments;

import java.util.List;

public interface CommentService {

    Comments createComment(Comments comment);
    Comments updateComment(Comments comment);
    List<Comments> listComments();

}

