package com.tochitopor.ExchToGIF.service;

import com.tochitopor.ExchToGIF.FeighInterface.OpenExchangeRatesFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OpenExchangeRatesService {
    private OpenExchangeRatesFeignClient openExchangeRatesFeignClient;

    public int getDifference(String apiKey, String date){
        openExchangeRatesFeignClient.getLatest(apiKey);
        return 0;
    }
}
