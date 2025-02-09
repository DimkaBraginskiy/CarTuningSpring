package com.api.carTuning.annotation.validator;

import com.api.carTuning.annotation.Email;

import java.util.regex.Pattern;

public class EmailValidator implements AnnotationValidator<String>{
    private static final String EMAIL_REGEX = "^[A-Za-z0-9.-]+@[A-Za-z0-9.-]+\\.[A_Za-z]{2,6}$";
    private final Pattern pattern;

    public EmailValidator(){
        this.pattern = Pattern.compile(EMAIL_REGEX);
    }

    @Override
    public boolean isValid(String value) {
        if(value == null){
            return false;
        }
        return pattern.matcher(value).matches();
    }
}
