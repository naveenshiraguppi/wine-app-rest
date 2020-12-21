package com.challenge.wineapprest.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreakdownService {
    @Autowired
    private WineJsonReaderService wineJsonReaderService;

    Map<String, WineLot> lotCodeMap;

    public BreakdownResponse findBreakdownForKey(String lotCode, final BreakdownKey key) {
        WineLot wineLot = lotCodeMap.get(lotCode);
        if(wineLot == null) {
            return null;
        }
        List<Breakdown> breakdowns = wineLot.getComponents().stream().map(c -> new Breakdown(key.apply(c), c.getPercentage())).collect(Collectors.toList());
        List<Breakdown> aggregatedBreakdowns = breakdowns.stream().collect(Collectors.groupingBy(Breakdown::getKey))
                .entrySet().stream().map(e -> new Breakdown(e.getKey(), e.getValue().stream().mapToDouble(Breakdown::getPercentage).sum()))
                .sorted(Comparator.comparingDouble(Breakdown::getPercentage).reversed())
                .collect(Collectors.toList());
        return new BreakdownResponse(key.getKeyName(), aggregatedBreakdowns);
    }

    @PostConstruct
    private void constructWineMemoryCache() {
        Map<String, List<WineLot>> lotMapToList = wineJsonReaderService.readWineLots().stream().collect(Collectors.groupingBy(WineLot::getLotCode));
        lotCodeMap = lotMapToList.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().stream().findAny().get()));
    }
}
