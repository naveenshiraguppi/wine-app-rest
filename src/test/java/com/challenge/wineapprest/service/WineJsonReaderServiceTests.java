package com.challenge.wineapprest.service;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

@SpringBootTest
class WineJsonReaderServiceTests {

    @InjectMocks
    private WineJsonReaderService wineJsonReaderService;

    @Test
    void readWineLots() {
        List<WineLot> lots = wineJsonReaderService.readWineLots();
        Assert.assertEquals(3, lots.size());
        Assert.assertTrue(lots.stream().noneMatch(l->l.getLotCode() == null));
    }
}
