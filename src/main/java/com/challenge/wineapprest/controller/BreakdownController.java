package com.challenge.wineapprest.controller;

import com.challenge.wineapprest.service.BreakdownKey;
import com.challenge.wineapprest.service.BreakdownResponse;
import com.challenge.wineapprest.service.BreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class BreakdownController {
    @Autowired
    private BreakdownService breakdownService;

    @RequestMapping("/breakdown/{keyType}/{lotCode}")
    public BreakdownResponse breakdownByKeyForLotCode(@PathVariable("keyType") BreakdownKey key, @PathVariable("lotCode") String lotCode) {
        return breakdownService.findBreakdownForKey(lotCode, key);
    }
}
