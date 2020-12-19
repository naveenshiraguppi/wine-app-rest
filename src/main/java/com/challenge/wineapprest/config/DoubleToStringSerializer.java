package com.challenge.wineapprest.config;

import com.challenge.wineapprest.service.BreakdownKey;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import org.springframework.core.convert.converter.Converter;

public class DoubleToStringSerializer extends StdSerializer<Double> {

    public DoubleToStringSerializer() {
        this(null);
    }

    public DoubleToStringSerializer(Class<Double> t) {
        super(t);
    }

    @Override
    public void serialize(
            Double value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeString(value.doubleValue() == value.intValue()? Integer.toString(value.intValue()):value.toString());
    }
}