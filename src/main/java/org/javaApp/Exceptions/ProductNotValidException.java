package org.javaApp.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductNotValidException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(ProductNotValidException.class);

    public ProductNotValidException(String message) {
        super(message);
        logger.error("Exception" + getClass() + " thrown");
    }
}
