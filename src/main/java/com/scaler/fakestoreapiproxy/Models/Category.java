package com.scaler.fakestoreapiproxy.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Category extends BaseModel{
    //private long id;
    private String category;
}
