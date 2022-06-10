package com.tochitopor.ExchToGIF.controller;

import com.tochitopor.ExchToGIF.service.OpenExchangeRatesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/host")
@AllArgsConstructor
public class MainMonolithController {
    OpenExchangeRatesService openExchangeRatesService;

    @GetMapping("/{coin}")
    public void doIt(@PathVariable String coin){
        ;
    }
}
