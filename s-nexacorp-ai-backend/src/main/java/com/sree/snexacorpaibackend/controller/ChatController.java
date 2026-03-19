package com.sree.snexacorpaibackend.controller;

import com.sree.snexacorpaibackend.dto.ChatRequest;
import com.sree.snexacorpaibackend.dto.ChatResponse;
import com.sree.snexacorpaibackend.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest chatRequest) {
        return chatService.chat(chatRequest);
    }
}
