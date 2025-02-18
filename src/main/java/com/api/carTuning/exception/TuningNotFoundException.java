package com.api.carTuning.exception;

public class TuningNotFoundException extends RuntimeException{
    public TuningNotFoundException(String message) {
        super(message);
    }
}
