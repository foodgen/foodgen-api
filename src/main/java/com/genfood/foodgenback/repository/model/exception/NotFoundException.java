package com.genfood.foodgenback.repository.model.exception;

public class NotFoundException extends ApiException {
    public NotFoundException(String message) {
        super(ExceptionType.CLIENT_EXCEPTION, message);
    }
}