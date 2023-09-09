package com.PhoneNumberSystem.exception;

public class AlreadyActivatedException extends RuntimeException{
    public AlreadyActivatedException(String message){
        super(message);
    }
}
