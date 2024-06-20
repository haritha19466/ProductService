package com.scaler.fakestoreapiproxy.DTOs;

import jdk.jfr.Category;
import lombok.Data;

@Data
public class FakeStoreResponseDto {
    private long id;
    private String Title;
    private double price;
    private String description;
    private String image;
    private String category;

}
