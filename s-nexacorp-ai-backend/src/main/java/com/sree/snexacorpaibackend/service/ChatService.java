package com.sree.snexacorpaibackend.service;

import com.sree.snexacorpaibackend.dto.ChatRequest;
import com.sree.snexacorpaibackend.dto.ChatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatClient chatClient;

    public ChatResponse chat(ChatRequest reqMessage) {
        String aiResponse = chatClient.prompt().user(reqMessage.getMessage())
                .call().content();
        return new ChatResponse(aiResponse);
    }
}
