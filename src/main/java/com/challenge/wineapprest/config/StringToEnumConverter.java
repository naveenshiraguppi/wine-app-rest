package com.challenge.wineapprest.config;

import com.challenge.wineapprest.service.BreakdownKey;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, BreakdownKey> {
    @Override
    public BreakdownKey convert(String source) {
        return BreakdownKey.valueOf(source.toUpperCase().replace('-', '_'));
    }
}