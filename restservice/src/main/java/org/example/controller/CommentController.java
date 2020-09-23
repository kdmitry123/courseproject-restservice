package org.example.controller;

import org.example.dto.CommentCmd;
import org.example.dto.CommentDto;
import org.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/add")
    public void addComment(@RequestBody CommentDto commentDto){
        commentService.addComment(commentDto);
    }

    @GetMapping("/getall")
    public List<CommentCmd> getCommentsByCollectionName(@RequestParam String collectionName){
        return commentService.getCommentsByCollectionName(collectionName);
    }

}
