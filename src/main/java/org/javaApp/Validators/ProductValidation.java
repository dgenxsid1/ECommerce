package org.javaApp.Validators;

import com.mysql.cj.util.StringUtils;
import org.javaApp.Exceptions.ErrorMessages;
import org.javaApp.Exceptions.ProductNotFoundException;
import org.javaApp.Exceptions.ProductNotValidException;
import org.javaApp.Model.Product;

public class ProductValidation {
    public static void execute(Product product){
        if(StringUtils.isNullOrEmpty(product.getName())){
            throw new ProductNotValidException(ErrorMessages.NAME_REQUIRED.getMessage());
        }

        if(product.getDescription().length() < 20){
            throw new ProductNotValidException(ErrorMessages.DESCRIPTION_LENGTH.getMessage());
        }

        if(product.getPrice() < 0.00){
            throw new ProductNotValidException(ErrorMessages.PRICE_CANNOT_BE_NEGATIVE.getMessage());
        }


        // code will throw Null Pointer exception and not come here.
        if(product.getPrice() == null){
            throw new ProductNotValidException(ErrorMessages.PRICE_CANNOT_BE_NULL.getMessage());
        }

    }
}
