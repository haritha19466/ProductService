package com.scaler.fakestoreapiproxy.InheritanceTypes.SingleTable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity

@DiscriminatorValue(value = "3")
public class Instructor extends User{
    //private String name;
    private double Instructorrating;
}
