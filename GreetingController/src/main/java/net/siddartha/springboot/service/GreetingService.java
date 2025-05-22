package net.siddartha.springboot.service;


import net.siddartha.springboot.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingService {

    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "GET");
        response.put("message", greetingService.getGreetingMessage());
        return response;
    }

    @PostMapping
    public Map<String, String> postGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "POST");
        response.put("message", greetingService.getGreetingMessage());
        return response;
    }

    @PutMapping
    public Map<String, String> putGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "PUT");
        response.put("message", greetingService.getGreetingMessage());
        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "DELETE");
        response.put("message", greetingService.getGreetingMessage());
        return response;
    }
}
