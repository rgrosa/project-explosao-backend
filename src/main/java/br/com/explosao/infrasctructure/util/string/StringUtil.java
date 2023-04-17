package br.com.explosao.infrasctructure.util.string;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Component
public class StringUtil {

    private StringUtil() {
    }

    public static List<String> stringWithComma2StringList(String text) {
        return !StringUtils.isEmpty(text)? Arrays.asList(text.split("\\s*,\\s*")):null;
    }
}
