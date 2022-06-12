package com.tochitopor.ExchToGIF.DTO;

import lombok.Value;

import java.util.Map;

@Value
public class GiphyDTO {
    Map[] data;
    Map pagination;
    Map meta;
}
