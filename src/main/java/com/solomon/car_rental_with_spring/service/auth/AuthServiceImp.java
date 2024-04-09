package com.solomon.car_rental_with_spring.service.auth;

import com.solomon.car_rental_with_spring.Entity.User;
import com.solomon.car_rental_with_spring.dto.SignUpRequest;
import com.solomon.car_rental_with_spring.dto.UserDto;
import com.solomon.car_rental_with_spring.enums.UserRole;
import com.solomon.car_rental_with_spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService{

    private final UserRepository userRepository;

    @Override
    public UserDto createdCustomer(SignUpRequest signUpRequest) {
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());

        return userDto;


    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
