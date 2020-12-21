package com.challenge.wineapprest.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WineLot {
    private String lotCode;
    private float volume;
    private String description;
    private String tankCode;
    private String productState;
    private String ownerName;
    List< Component > components = new ArrayList<>();

    @JsonIgnore
    public List<Component> getComponentsForYear(final int year) {
        return components.stream().filter(c->c.getYear() == year).collect(Collectors.toList());
    }
    @JsonIgnore
    public List<Component> getComponentsForVariety(final String variety) {
        return components.stream().filter(c->c.getVariety()!=null).filter(c-> c.getVariety().equalsIgnoreCase(variety)).collect(Collectors.toList());
    }
    @JsonIgnore
    public List<Component> getComponentsForRegion(final String region) {
        return components.stream().filter(c->c.getRegion()!=null).filter(c-> c.getRegion().equalsIgnoreCase(region)).collect(Collectors.toList());
    }
}
