package com.challenge.wineapprest;

import com.challenge.wineapprest.config.StringToEnumConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WineAppRestApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(WineAppRestApplication.class, args);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConverter());
    }
}
