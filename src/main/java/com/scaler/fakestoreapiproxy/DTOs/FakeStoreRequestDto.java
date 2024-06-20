package com.scaler.fakestoreapiproxy.DTOs;

import lombok.Data;

@Data
public class FakeStoreRequestDto {
    //private long id;
    private String Title;
    private double price;
    private String description;
    private String image;
    private String category;
}
