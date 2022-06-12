package com.tochitopor.ExchToGIF.FeighInterface;

import com.tochitopor.ExchToGIF.DTO.GiphyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "giphy", url = "${giphy.url}")
public interface GiphyFeignClient {
    @GetMapping("?apikey={apiKey}&q={query}&limit=1&offset={offset}&bundle=messaging_non_clips")
    GiphyDTO getGiphy(@PathVariable String apiKey, @PathVariable String query,@PathVariable String offset);
}