package net.siddartha.springboot.service;

import net.siddartha.springboot.entity.Greeting;
import net.siddartha.springboot.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting createGreeting(String firstName, String lastName) {
        String message;

        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello Mr./Ms. " + lastName + "!";
        } else {
            message = "Hello World!";
        }

        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Optional<Greeting> updateGreetingMessage(Long id, String newMessage) {
        return greetingRepository.findById(id).map(existingGreeting -> {
            existingGreeting.setMessage(newMessage);
            return greetingRepository.save(existingGreeting);
        });
    }

    // ✅ NEW METHOD to delete by ID
    public boolean deleteGreetingById(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
