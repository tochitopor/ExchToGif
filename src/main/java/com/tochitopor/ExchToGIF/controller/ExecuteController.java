package com.tochitopor.ExchToGIF.controller;

import com.tochitopor.ExchToGIF.service.GiphyService;
import com.tochitopor.ExchToGIF.service.OpenExchangeRatesService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/host")
@NoArgsConstructor
//@AllArgsConstructor
public class ExecuteController {
    @Value("${openexch.apiKey}")
    private String exchApiKey;

    @Value("${giphy.apiKey}")
    private String giphyApiKey;
    @Autowired // пришлось инжектить через @Autowired, с @AllArgsConstructor что-то не срослось!
    OpenExchangeRatesService openExchangeRatesService;
    @Autowired // пришлось инжектить через @Autowired, с @AllArgsConstructor что-то не срослось!
    GiphyService giphyService;

    @GetMapping("/{coin}")
    public String execute(@PathVariable String coin){
        String url;

        boolean b = openExchangeRatesService.isGreater(exchApiKey, coin);
        if(openExchangeRatesService.isGreater(exchApiKey, coin)){
            url = giphyService.getGiphy(giphyApiKey,
                    "rich",
                    String.valueOf(new Random().nextInt(4999)));
        }
        else{
            url = giphyService.getGiphy(giphyApiKey,
                    "broke",
                    String.valueOf(new Random().nextInt(4999)));
        }

        return "<html>" +
                "<head><title>"+ "ExcToGIF" +"</title></head>" +
                "<body><img src=\"" + url + "\"></body>" +
                "</html>";
    }
}
