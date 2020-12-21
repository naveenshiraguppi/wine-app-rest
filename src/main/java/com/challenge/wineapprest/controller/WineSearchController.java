package com.challenge.wineapprest.controller;

import com.challenge.wineapprest.service.BreakdownKey;
import com.challenge.wineapprest.service.BreakdownResponse;
import com.challenge.wineapprest.service.BreakdownService;
import com.challenge.wineapprest.service.WineLot;
import com.challenge.wineapprest.service.WineLotSearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class WineSearchController {
    @Autowired
    private BreakdownService breakdownService;
    @Autowired
    private WineLotSearchService wineLotSearchService;

    @RequestMapping("/breakdown/{keyType}/{lotCode}")
    public BreakdownResponse breakdownByKeyForLotCode(@PathVariable("keyType") BreakdownKey key, @PathVariable("lotCode") String lotCode) {
        return breakdownService.findBreakdownForKey(lotCode, key);
    }
    @RequestMapping("/search/{criteria}")
    public List<WineLot> searchWineLot(@PathVariable("criteria") String criteria) {
        return wineLotSearchService.searchWineLot(criteria);
    }
}
