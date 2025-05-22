package net.siddartha.springboot.repository;

import net.siddartha.springboot.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
	
}