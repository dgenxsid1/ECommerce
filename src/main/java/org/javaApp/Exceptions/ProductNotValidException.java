package org.javaApp.Exceptions;

public class ProductNotValidException extends RuntimeException{

    public ProductNotValidException(String message) {
        super(message);
    }
}
