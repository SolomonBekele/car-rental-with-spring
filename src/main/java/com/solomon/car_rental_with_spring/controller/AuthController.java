package com.solomon.car_rental_with_spring.controller;

import com.solomon.car_rental_with_spring.dto.SignUpRequest;
import com.solomon.car_rental_with_spring.dto.UserDto;
import com.solomon.car_rental_with_spring.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    private ResponseEntity<?> signupCustomer(@RequestBody SignUpRequest signUpRequest){
        if (authService.hasCustomerWithEmail(signUpRequest.getEmail())){
            return new ResponseEntity<>("Customer is already registered",HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdCustomerDto =authService.createdCustomer(signUpRequest);
        if (createdCustomerDto == null) return new ResponseEntity<>
                ("Customer not Created, come again later", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdCustomerDto,HttpStatus.CREATED);
    }
}
