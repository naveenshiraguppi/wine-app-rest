package com.challenge.wineapprest.service;

import com.challenge.wineapprest.config.DoubleToStringSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Breakdown {
    @JsonSerialize(using = DoubleToStringSerializer.class)
    private double percentage;
    private String key;
    public Breakdown(String key, double percentage) {
        this.percentage = percentage;
        this.key = key;
    }
}
