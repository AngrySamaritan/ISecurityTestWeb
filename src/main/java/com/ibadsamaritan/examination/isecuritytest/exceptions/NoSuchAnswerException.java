package com.ibadsamaritan.examination.isecuritytest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "No answer with such id in database")
public class NoSuchAnswerException extends Throwable {
    public NoSuchAnswerException(String s) {
        super(s);
    }
}
