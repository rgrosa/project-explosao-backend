package br.com.explosao.infrasctructure.util.date;

import br.com.explosao.infrasctructure.exception.RFC3339DateFormatConverterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class RFC3339DateFormatConverter {
    public static LocalDateTime string2LocalDateTime(String value, String pattern) throws RFC3339DateFormatConverterException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern).withZone(ZoneId.of("UTC"));
            return LocalDateTime.parse(value, formatter);
        }catch(Exception ex){
            throw new RFC3339DateFormatConverterException(ex.getMessage());
        }
    }
}