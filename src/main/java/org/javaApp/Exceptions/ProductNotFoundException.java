package org.javaApp.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(ProductNotFoundException.class);
    public ProductNotFoundException(String message){
        super(message);
    }
    public ProductNotFoundException(){
        super(ErrorMessages.PRODUCT_NOT_FOUND.getMessage());
        logger.error("Exception" + getClass() + " thrown");
    }
}

/*
{
    "timestamp": "2024-11-30T06:21:36.353+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Product Not Found",
    "path": "/product/10"
}

This is the response it thrown,
its status is not correct, it should be 404.
so we will do a @ResponseStatus.
 */
