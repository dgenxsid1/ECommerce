package org.javaApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(){
        super(ErrorMessages.PRODUCT_NOT_FOUND.getMessage());
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
