package com.tochitopor.ExchToGIF.FeighInterface;

import com.tochitopor.ExchToGIF.DTO.OpenExchangeRatesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "openexch", url = "${openexch.url}")
public interface OpenExchangeRatesFeignClient {
    @GetMapping("latest.json?app_id={appID}")
    OpenExchangeRatesDTO getLatest(@PathVariable String appID);

    @GetMapping("historical/{date}.json?app_id={appID}")
    OpenExchangeRatesDTO getLatest(@PathVariable String appID, @PathVariable String date);
}
