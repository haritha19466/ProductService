package com.scaler.fakestoreapiproxy.InheritanceTypes.Tablerperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name="User_STC")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    private int id;
    private String name;
    private String email;
    private String password;
}
