package com.scaler.fakestoreapiproxy.InheritanceTypes.Tablerperclass;

import jakarta.persistence.Entity;

@Entity(name="TA_STC")
public class TA extends User {
    private String domain;
}
