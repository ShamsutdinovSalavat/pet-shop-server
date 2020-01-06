package ru.termpaper.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity handleConflict(Exception exc) {
		LOG.error("", exc);

		return ResponseEntity.ok().build();
	}

}
