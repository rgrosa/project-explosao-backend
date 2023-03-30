package br.com.explosao.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class PasswordException extends Exception{

    private static final long serialVersionUID = 1L;

    public PasswordException(final String message) {
        super(message);
    }
}
