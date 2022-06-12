package com.tochitopor.ExchToGIF.service;


import com.tochitopor.ExchToGIF.DTO.GiphyDTO;
import com.tochitopor.ExchToGIF.FeighInterface.GiphyFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Service
@AllArgsConstructor
public class GiphyService {
    private GiphyFeignClient giphyFeignClient;

    public String getGiphy(String apiKey, String query, String offset){
        GiphyDTO DTO = giphyFeignClient.getGiphy(apiKey, query, offset);
        Map map = (Map)DTO.getData()[0].get("images");
        map = (Map)map.get("original");

        return (String)map.get("url");
    }
}
