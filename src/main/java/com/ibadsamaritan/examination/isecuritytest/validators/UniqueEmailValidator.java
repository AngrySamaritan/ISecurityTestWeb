package com.ibadsamaritan.examination.isecuritytest.validators;

import com.ibadsamaritan.examination.isecuritytest.model.UserDto;
import com.ibadsamaritan.examination.isecuritytest.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public final class UniqueEmailValidator implements ConstraintValidator<ValidEmail, UserDto> {

    @Autowired
    UserRepo userRepo;

    @Override
    public void initialize(ValidEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
        return userRepo.getIdByEmail(userDto.getEmail()).size() == 0;
    }
}
