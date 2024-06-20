package com.scaler.fakestoreapiproxy.InheritanceTypes.Tablerperclass;

import jakarta.persistence.Entity;

@Entity(name="STC_Mentor")
public class Mentor extends User {
    //private String name;
    private int mentorrating;

}
