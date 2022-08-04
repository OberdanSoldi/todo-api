package com.github.oberdan.dev.todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Item Not Found")
public class TodoNotFoundException extends ServiceErrorException {
}
