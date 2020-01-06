package ru.termpaper.shop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import ru.termpaper.shop.model.User;


public class JacksonTest {

	@Test
	public  void jsontest() throws JsonProcessingException {
		String json = "{\n" +
				"  \"email\": \"s@gmail.com\",\n" +
				"  \"password\": \"12345\",\n" +
				"  \"zipCode\": \"123123\",\n" +
				"  \"phoneNumber\": \"123123131\",\n" +
				"  \"role\": \"USER\",\n" +
				"  \"firstName\": \"Ilaya\",\n" +
				"  \"lastName\": \"Medivi\",\n" +
				"  \"country\": \"Russia\",\n" +
				"  \"city\": \"Moskow\",\n" +
				"  \"street\": \"Arbat, 3\"\n" +
				"}";
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.readValue(json, User.class));
	}
}
