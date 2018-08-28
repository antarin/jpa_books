package com.mazsi.jpademo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Mert buta vagy és nem tudod a saját jelszavad :p")
public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException() {
        super();
    }
}
