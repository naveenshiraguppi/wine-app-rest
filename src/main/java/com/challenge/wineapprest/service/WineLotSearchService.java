package com.challenge.wineapprest.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class WineLotSearchService {
    @Autowired
    private WineJsonReaderService wineJsonReaderService;

    List<WineLot>  lots;

    @PostConstruct
    private void constructWineMemoryCache() {
        lots = wineJsonReaderService.readWineLots();
    }

    public List<WineLot> searchWineLot(String criteria) {
        Assert.notNull(criteria, "Input criteria is null");
        return lots.stream().filter(l -> (l.getLotCode().startsWith(criteria)
                || (l.getDescription() != null?l.getDescription().startsWith(criteria):false))).collect(Collectors.toList());
    }
}
