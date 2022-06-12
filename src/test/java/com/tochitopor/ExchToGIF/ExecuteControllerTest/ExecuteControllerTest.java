package com.tochitopor.ExchToGIF.ExecuteControllerTest;

import com.tochitopor.ExchToGIF.controller.ExecuteController;
import com.tochitopor.ExchToGIF.service.GiphyService;
import com.tochitopor.ExchToGIF.service.OpenExchangeRatesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class ExecuteControllerTest {
    @Value("${openexch.apiKey}")
    private String exchApiKey;

    @Value("${giphy.apiKey}")
    private String giphyApiKey;

    @Autowired
    ExecuteController executeController;

    @MockBean
    OpenExchangeRatesService openExchangeRatesService;
    @MockBean
    GiphyService giphyService;

    @Test
    // я не знаю как тестировать случайные велечины :(
    public void executeTest(){
//        Mockito.doReturn(true).when(openExchangeRatesService).isGreater(exchApiKey,"rub");
//        Mockito.doReturn(false).when(openExchangeRatesService).isGreater(exchApiKey,"usd");

//        Mockito.doReturn("rich").when(giphyService).getGiphy(giphyApiKey,"rich",anyString());
//        Mockito.doReturn("broke").when(giphyService).getGiphy(giphyApiKey,"broke",anyString());

//        Assertions.assertEquals("rich",executeController.execute("rub"));
//        Assertions.assertEquals("broke",executeController.execute("usd"));
    }
}
