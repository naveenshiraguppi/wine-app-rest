package com.challenge.wineapprest.service;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreakdownResponse {
    private String breakDownType;
    private List<Breakdown> breakdown = new ArrayList<>();
    public BreakdownResponse(String type, List<Breakdown> breakdowns) {
        this.breakDownType = type;
        this.breakdown.addAll(breakdowns);
    }
}
