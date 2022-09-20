package com.example.backend.validator;

import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@RequiredArgsConstructor
public final class UniqueUserNameValidator implements ConstraintValidator<UniqueUsernName,String> {

    @Override
    public void initialize(UniqueUsernName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    private final UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsUserByUserName(username);
    }
}
