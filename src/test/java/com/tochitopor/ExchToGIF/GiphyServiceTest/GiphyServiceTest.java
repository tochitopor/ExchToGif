package com.tochitopor.ExchToGIF.GiphyServiceTest;

import com.tochitopor.ExchToGIF.DTO.GiphyDTO;
import com.tochitopor.ExchToGIF.FeighInterface.GiphyFeignClient;
import com.tochitopor.ExchToGIF.service.GiphyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class GiphyServiceTest {
    @Autowired
    GiphyService giphyService;

    @MockBean
    private GiphyFeignClient giphyFeignClient;

    @Test
    public void getGiphy(){
        Map<String, String> url = new HashMap();
        url.put("url","link");
        Map<String, Map> original = new HashMap();
        original.put("original",url);
        Map<String, Map> images = new HashMap();
        images.put("images",original);

        Map<String, Map>[] data = new Map[]{images};

        GiphyDTO DTO  = new GiphyDTO(data,null,null);
        Mockito.doReturn(DTO).when(giphyFeignClient).getGiphy("","", "");

        Assertions.assertEquals("link",giphyService.getGiphy("","",""));
    }
}
