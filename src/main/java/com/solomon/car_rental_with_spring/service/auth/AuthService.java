package com.solomon.car_rental_with_spring.service.auth;

import com.solomon.car_rental_with_spring.dto.SignUpRequest;
import com.solomon.car_rental_with_spring.dto.UserDto;

public interface AuthService {
    UserDto createdCustomer(SignUpRequest signUpRequest);


    boolean hasCustomerWithEmail(String email);
}
