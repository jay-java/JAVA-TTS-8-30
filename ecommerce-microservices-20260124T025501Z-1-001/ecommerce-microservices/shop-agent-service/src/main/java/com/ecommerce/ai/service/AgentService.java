package com.ecommerce.ai.service;

import com.ecommerce.ai.client.ProductClient;
import com.ecommerce.ai.dto.ProductDTO;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class AgentService {

    private final ChatClient chatClient;

    public AgentService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String callAgent(String query) {
        return chatClient.prompt()
                .user(query)
                .functions("getAllProducts") // Enable the tool
                .call()
                .content();
    }

    @Bean
    @Description("Get all available products from the store")
    public Function<String, List<ProductDTO>> getAllProducts(ProductClient productClient) {
        return (request) -> {
            // Request matches the input type (String in this case, ignored)
            return productClient.getAllProducts();
        };
    }
}
