package com.solomon.car_rental_with_spring.dto;

import lombok.Data;

@Data
public class SignUpRequest {

    private String email;
    private String name;
    private String password;
}
