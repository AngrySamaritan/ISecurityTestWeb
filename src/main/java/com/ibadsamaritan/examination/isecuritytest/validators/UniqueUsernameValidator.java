package com.ibadsamaritan.examination.isecuritytest.validators;

import com.ibadsamaritan.examination.isecuritytest.model.UserDto;
import com.ibadsamaritan.examination.isecuritytest.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, UserDto> {

    @Autowired
    UserRepo userRepo;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
        return userRepo.getIdByUsername(userDto.getUsername()).size() == 0;
    }
}
