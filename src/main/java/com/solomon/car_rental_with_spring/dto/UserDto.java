package com.solomon.car_rental_with_spring.dto;

import com.solomon.car_rental_with_spring.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
}
