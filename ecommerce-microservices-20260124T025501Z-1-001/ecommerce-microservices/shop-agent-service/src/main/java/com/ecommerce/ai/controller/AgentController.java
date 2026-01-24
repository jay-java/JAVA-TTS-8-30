package com.ecommerce.ai.controller;

import com.ecommerce.ai.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping("/chat")
    public String chat(@RequestParam String query) {
        return agentService.callAgent(query);
    }
}
