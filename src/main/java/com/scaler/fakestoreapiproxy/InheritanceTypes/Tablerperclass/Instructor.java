package com.scaler.fakestoreapiproxy.InheritanceTypes.Tablerperclass;

import jakarta.persistence.Entity;

@Entity(name="STC_instructor")
public class Instructor extends User {
    //private String name;
    private double Instructorrating;
}
