package br.com.explosao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RFC3339DateFormatConverterException extends Exception{

	private static final long serialVersionUID = 1L;

	public RFC3339DateFormatConverterException(final String message) {
    	super(message);
    }
}
