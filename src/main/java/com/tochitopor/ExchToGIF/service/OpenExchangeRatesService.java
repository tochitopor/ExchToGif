package com.tochitopor.ExchToGIF.service;

import com.tochitopor.ExchToGIF.DTO.OpenExchangeRatesDTO;
import com.tochitopor.ExchToGIF.FeighInterface.OpenExchangeRatesFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
@AllArgsConstructor
public class OpenExchangeRatesService {
    private OpenExchangeRatesFeignClient openExchangeRatesFeignClient;

    public boolean isGreater(String apiKey, String coin){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar();

        BigDecimal currentValue = getCoinValue(apiKey, df.format(calendar.getTime()), coin.toUpperCase());

        calendar.add(Calendar.DAY_OF_YEAR,-1);
        BigDecimal yestrdayValue = getCoinValue(apiKey, df.format(calendar.getTime()), coin.toUpperCase());

        return currentValue.compareTo(yestrdayValue) >= 0;
    }

    private BigDecimal getCoinValue(String apiKey, String date, String coin){
        OpenExchangeRatesDTO DTO = openExchangeRatesFeignClient.getHistorical(apiKey, date);

        if(DTO.getRates().containsKey(coin)){
            String s = DTO.getRates().get(coin);
            BigDecimal b = new BigDecimal(s);
            return new BigDecimal( DTO.getRates().get(coin));
        }
        else{
            //логирование
            //обработка, тогда и null возвращать не надо будет
            return null;
        }
    }
}
