package br.com.explosao.util.date;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.text.FieldPosition;
import java.util.Date;
import java.util.TimeZone;

public class RFC3339DateFormat extends ISO8601DateFormat {

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        String value = ISO8601Utils.format(date, false, TimeZone.getDefault());
        toAppendTo.append(value);
        return toAppendTo;
    }

}
