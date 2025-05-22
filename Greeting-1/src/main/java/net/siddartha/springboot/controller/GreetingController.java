package net.siddartha.springboot.controller;

import net.siddartha.springboot.dto.GreetingRequest;
import net.siddartha.springboot.repository.GreetingRepository;
import net.siddartha.springboot.entity.Greeting;
import net.siddartha.springboot.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    // ✅ Create Greeting
    @PostMapping
    public String greet(@RequestBody GreetingRequest request) {
        Greeting greeting = greetingService.createGreeting(request.getFirstName(), request.getLastName());
        return greeting.getMessage();
    }

    // ✅ Get Greeting by ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id)
                .map(greeting -> ResponseEntity.ok(greeting.getMessage()))
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Get All Greetings
    @GetMapping
    public List<String> getAllGreetingMessages() {
        return greetingService.getAllGreetings()
                .stream()
                .map(Greeting::getMessage)
                .toList();
    }

    // ✅ Update Greeting by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateGreeting(@PathVariable Long id, @RequestBody String newMessage) {
        return greetingService.updateGreetingMessage(id, newMessage)
                .map(updated -> ResponseEntity.ok("Greeting updated successfully."))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGreeting(@PathVariable Long id) {
        boolean deleted = greetingService.deleteGreetingById(id);
        if (deleted) {
            return ResponseEntity.ok("Greeting deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
