package com.api.carTuning.annotation.validator;

public interface AnnotationValidator<T> {
    boolean isValid(T value);
}
