package ru.termpaper.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.termpaper.shop.model.User;
import ru.termpaper.shop.repository.UserRepository;

@RestController
@RequestMapping(
		path = "/user",
		produces = "application/json"
)
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepository userRepository;

	private final static Logger log = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PATCH})
	public ResponseEntity save(@RequestBody User user) {
		log.debug("Saving user: {}", user);
		this.userRepository.save(user);
		return ResponseEntity.ok().build();
	}

}
