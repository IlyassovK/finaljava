package com.ilyassov.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements
        ConstraintValidator<PasswordValidatorConstraint, String> {

    @Override
    public void initialize(PasswordValidatorConstraint password) {
    }

    @Override
    public boolean isValid(String password,
                           ConstraintValidatorContext cxt) {
        return password != null && (password.length() > 8) && (password.length() < 14);
    }

}