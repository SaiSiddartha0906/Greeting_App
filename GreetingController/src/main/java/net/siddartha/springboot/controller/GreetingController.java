package net.siddartha.springboot.controller;



import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "GET");
        response.put("message", "Hello from GET");
        return response;
    }

    @PostMapping
    public Map<String, String> postGreeting() {
        Map<String, String> response = new HashMap<>(); 
        response.put("method", "POST");
        response.put("message", "Hello from POST");
        return response;
    }

    @PutMapping
    public Map<String, String> putGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "PUT");
        response.put("message", "Hello from PUT");
        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "DELETE");
        response.put("message", "Hello from DELETE");
        return response;
    }
}
