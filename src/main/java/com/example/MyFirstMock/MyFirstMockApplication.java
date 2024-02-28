package com.example.MyFirstMock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
@SpringBootApplication
public class MyFirstMockApplication {


//	@Bean
//	@Primary
//	public ObjectMapper objectMapper() {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
//		mapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, true);
//		return mapper;
//	}

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMockApplication.class, args);
	}

}
