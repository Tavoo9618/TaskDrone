package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoApplicationTests {

	@GetMapping("/error")
	public String index() {
		return "Greetings from Spring Boot!";
	}
        

}
