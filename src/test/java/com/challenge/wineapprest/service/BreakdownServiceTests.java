package com.challenge.wineapprest.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BreakdownServiceTests {

    @Autowired
    private BreakdownService breakdownService;

    @Test
    void findBreakdownForYear() {
        BreakdownResponse response = breakdownService.findBreakdownForKey("11YVCHAR001", BreakdownKey.YEAR);
        Assert.assertEquals("year", response.getBreakDownType());
        Assert.assertEquals(2, response.getBreakdown().size());
        Assert.assertEquals("2011", getKey(response, 0));
        Assert.assertEquals(Double.valueOf("85.0").intValue(), (int) getPercentage(response, 0));
        Assert.assertEquals("2010", getKey(response, 1));
        Assert.assertEquals(Double.valueOf("15.0").intValue(), (int) getPercentage(response, 1));
    }

    private String getKey(BreakdownResponse response, int i) {
        return response.getBreakdown().get(i).getKey();
    }

    @Test
    void findBreakdownForVariety() {
        BreakdownResponse response = breakdownService.findBreakdownForKey("11YVCHAR001", BreakdownKey.VARIETY);
        Assert.assertEquals("variety", response.getBreakDownType());
        Assert.assertEquals(2, response.getBreakdown().size());
        Assert.assertEquals("Pinot Noir", getKey(response, 1));
        Assert.assertEquals(Double.valueOf("10.0").intValue(), (int) getPercentage(response, 1));
        Assert.assertEquals("Chardonnay", getKey(response, 0));
        Assert.assertEquals(Double.valueOf("90.0").intValue(), (int) getPercentage(response, 0));
    }

    @Test
    void findBreakdownForRegion() {
        BreakdownResponse response = breakdownService.findBreakdownForKey("11YVCHAR001", BreakdownKey.REGION);
        Assert.assertEquals("region", response.getBreakDownType());
        Assert.assertEquals(3, response.getBreakdown().size());
        Assert.assertEquals("Mornington", getKey(response, 2));
        Assert.assertEquals(Double.valueOf("5.0").intValue(), (int) getPercentage(response, 2));
        Assert.assertEquals("Yarra Valley", getKey(response, 0));
        Assert.assertEquals(Double.valueOf("80.0").intValue(), (int) getPercentage(response, 0));
        Assert.assertEquals("Macedon", getKey(response, 1));
        Assert.assertEquals(Double.valueOf("15.0").intValue(), (int) getPercentage(response, 1));
    }

    @Test
    void findBreakdownForYearVariety() {
        BreakdownResponse response = breakdownService.findBreakdownForKey("11YVCHAR001", BreakdownKey.YEAR_VARIETY);
        Assert.assertEquals("year-variety", response.getBreakDownType());
        Assert.assertEquals(4, response.getBreakdown().size());
        Assert.assertEquals("2010-Chardonnay", getKey(response, 1));
        Assert.assertEquals(Double.valueOf("10.0").intValue(), (int) getPercentage(response, 1));
        Assert.assertEquals("2011-Chardonnay", getKey(response, 0));
        Assert.assertEquals(Double.valueOf("80.0").intValue(), (int) getPercentage(response, 0));
        Assert.assertEquals("2011-Pinot Noir", getKey(response, 2));
        Assert.assertEquals(Double.valueOf("5.0").intValue(), (int) getPercentage(response, 2));
        Assert.assertEquals("2010-Pinot Noir", getKey(response, 3));
        Assert.assertEquals(Double.valueOf("5.0").intValue(), (int) getPercentage(response, 3));
    }

    private double getPercentage(BreakdownResponse response, int i) {
        return response.getBreakdown().get(i).getPercentage();
    }
}
