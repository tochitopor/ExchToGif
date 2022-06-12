package com.tochitopor.ExchToGIF.OpenExchangeRatesServiceTest;

import com.tochitopor.ExchToGIF.DTO.OpenExchangeRatesDTO;
import com.tochitopor.ExchToGIF.FeighInterface.OpenExchangeRatesFeignClient;
import com.tochitopor.ExchToGIF.service.OpenExchangeRatesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest
public class OpenExchangeRatesServiceTests {
    @Autowired
    OpenExchangeRatesService openExchangeRatesService;

    @MockBean
    private OpenExchangeRatesFeignClient openExchangeRatesFeignClient;

    @Test
    public void isGreaterTest(){
        Map<String,String> map1 = new HashMap<>();
        map1.put("USD", "1");
        map1.put("RUB", "0.46");

        Map<String,String> map2 = new HashMap<>();
        map2.put("USD", "1");
        map2.put("RUB", "0.45");

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar();

        OpenExchangeRatesDTO currentDTO = new OpenExchangeRatesDTO("d","l","ts","b", map1);
        OpenExchangeRatesDTO yesterdayDTO = new OpenExchangeRatesDTO("d","l","ts","b", map2);
        Mockito.doReturn(currentDTO).when(openExchangeRatesFeignClient).getHistorical("",df.format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_YEAR,-1);
        Mockito.doReturn(yesterdayDTO).when(openExchangeRatesFeignClient).getHistorical("",df.format(calendar.getTime()));

        boolean b = openExchangeRatesService.isGreater("","rub");
        Assertions.assertTrue(openExchangeRatesService.isGreater("","rub"));
    }

    //надо ли тестировать приватный метод и как?
    //@Test
    //void getCoinValueTest(){}

}
