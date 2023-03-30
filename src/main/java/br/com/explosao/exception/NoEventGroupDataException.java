package br.com.explosao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoEventGroupDataException extends Exception{

    private static final long serialVersionUID = 1L;

    public NoEventGroupDataException(final String message) {
        super(message);
    }
}
