package com.scaler.fakestoreapiproxy.InheritanceTypes.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "2")
public class Mentor extends User{
    //private String name;
    private int mentorrating;

}
