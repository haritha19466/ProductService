package com.scaler.fakestoreapiproxy.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@MappedSuperclass
@Data
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// we are thsfield to be used as PK.
    private Date createdAt;
    private Date updatedAt;

}
