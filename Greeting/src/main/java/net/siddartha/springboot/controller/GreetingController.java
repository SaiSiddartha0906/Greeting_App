package net.siddartha.springboot.controller;

import net.siddartha.springboot.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public Map<String, String> getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        Map<String, String> response = new HashMap<>();
        response.put("method", "GET");
        response.put("message", greetingService.getGreetingMessage(firstName, lastName));
        return response;
    }

    // Similarly update other HTTP methods if needed (optional)
}
