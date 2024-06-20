package com.scaler.fakestoreapiproxy.DTOs;

import lombok.Data;

import java.util.List;
@Data
public class UserDto {
    private String name;
    private String email;
    private List<Roles> roles;
}
