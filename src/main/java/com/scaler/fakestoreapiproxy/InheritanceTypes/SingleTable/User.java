package com.scaler.fakestoreapiproxy.InheritanceTypes.SingleTable;

import jakarta.persistence.*;

@Entity(name="SINGLETABLE_User")
@DiscriminatorColumn(
        name="User_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value="0")
public class User {
    @Id
    private int id;
    private String name;
    private String email;
    private String password;
}
