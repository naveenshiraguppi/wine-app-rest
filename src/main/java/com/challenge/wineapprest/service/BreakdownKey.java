package com.challenge.wineapprest.service;

import java.util.function.Function;

public enum BreakdownKey implements Function<Component, String> {
    YEAR("year", c -> Integer.toString(c.getYear())),
    VARIETY("variety", c -> c.getVariety()),
    REGION("region", c -> c.getRegion()),
    YEAR_VARIETY("year-variety", c -> Integer.toString(c.getYear()) + "-" + c.getVariety());

    private final String keyName;
    private final Function<Component, String> getKey;

    private BreakdownKey(final String keyName, final Function<Component, String> getKey) {
        this.keyName = keyName;
        this.getKey = getKey;
    }

    @Override
    public String apply(final Component component) {
        return getKey.apply(component);
    }
    public String getKeyName() {
        return keyName;
    }
}
