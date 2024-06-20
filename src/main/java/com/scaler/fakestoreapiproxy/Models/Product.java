package com.scaler.fakestoreapiproxy.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
@Entity
public class Product extends BaseModel{
    //private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    @ManyToOne
    private Category category;
}
