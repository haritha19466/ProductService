package com.scaler.fakestoreapiproxy.InheritanceTypes.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "1")
public class TA extends User{
    private String domain;
}
