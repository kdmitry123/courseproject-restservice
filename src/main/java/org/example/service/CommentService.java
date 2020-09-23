package org.example.service;

import org.example.dto.CommentCmd;
import org.example.dto.CommentDto;
import org.example.pojo.Comment;
import org.example.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CollectionService collectionService;

    public List<CommentCmd> getCommentsByCollectionName(String name){
        List<CommentCmd> commentCmdList = new ArrayList<>();
        commentRepository.findCommentsByCollection_Name(name).get().forEach(comment -> commentCmdList.add(new CommentCmd(comment.getText())));
        return commentCmdList;
    }

    public void addComment(CommentDto commentDto){
        String collectionName = commentDto.getCollectionName();
        if(collectionService.collectionNameIsPresent(collectionName)){
            Comment comment = new Comment();
            comment.setText(commentDto.getText());
            comment.setCollection(collectionService.getCollectionByName(commentDto.getCollectionName()));
            commentRepository.save(comment);
        }
    }
}
