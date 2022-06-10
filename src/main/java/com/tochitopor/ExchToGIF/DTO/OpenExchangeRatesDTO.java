package com.tochitopor.ExchToGIF.DTO;

import lombok.Value;

import java.util.Map;

@Value
public class OpenExchangeRatesDTO {
    String disclaimer;
    String license;
    String timestamp;
    String base;
    Map<String, String> rates;
}