package ru.termpaper.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.termpaper.shop.model.User;
import ru.termpaper.shop.repository.UserRepository;

import java.util.Optional;
import java.util.logging.ErrorManager;

@RestController
@RequestMapping(path = "/signIn",
		produces = "application/json"
)
@CrossOrigin
public class SignInController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public ResponseEntity getSignInPage(@RequestBody User user) {
		Optional<User> byEmail = this.userRepository.findByEmail(user.getEmail());
		if (byEmail.isPresent()) {
			User dbUser = byEmail.get();
			if (dbUser.getPassword().equals(user.getPassword())) {
				return ResponseEntity.ok(dbUser);
			} else {
				return new ResponseEntity<>(
						ErrorCode.INVALID_PASSWORD.name(), HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(
					ErrorCode.INVALID_EMAIL.name(), HttpStatus.NOT_FOUND);
		}
	}



	enum ErrorCode {
		INVALID_EMAIL, INVALID_PASSWORD
	}

}
