package com.api.carTuning.annotation.validator;

import com.api.carTuning.annotation.Email;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<Email, String> {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9.-]+@[A-Za-z0-9.-]+\\.[A_Za-z]{2,6}$";
    private final Pattern pattern = Pattern.compile(EMAIL_REGEX);


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }
        return pattern.matcher(value).matches();//check whether email matches with regex
    }
}
