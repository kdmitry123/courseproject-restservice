package org.example.controller;

import org.example.dto.CommentDto;
import org.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketCommentController {

    @Autowired
    CommentService commentService;

    @MessageMapping("/sendComment")
    @SendTo("/topic/greetings")
    public void greeting(CommentDto commentDto) {
       commentService.addComment(commentDto);
    }

}
