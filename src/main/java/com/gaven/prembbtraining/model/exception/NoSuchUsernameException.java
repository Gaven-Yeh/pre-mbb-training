package com.gaven.prembbtraining.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Username")
public class NoSuchUsernameException extends NoSuchElementException {
}
