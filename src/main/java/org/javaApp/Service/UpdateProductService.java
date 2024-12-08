package org.javaApp.Service;

import org.javaApp.Exceptions.ErrorMessages;
import org.javaApp.Exceptions.ProductNotFoundException;
import org.javaApp.Model.Product;
import org.javaApp.Model.ProductDTO;
import org.javaApp.Model.UpdateProductCommand;
import org.javaApp.Repository.ProductRepository;
import org.javaApp.Validators.ProductValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO>{
    private static final Logger logger = LoggerFactory.getLogger(UpdateProductService.class);


    private ProductRepository productRepository;
    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
      logger.info("Executing" + getClass());
        Optional<Product> productOptional = productRepository.findById(command.getId());
      if(productOptional.isPresent()){
          Product product = command.getProduct();
          product.setId(command.getId());
          ProductValidation.execute(product);
          productRepository.save(product);
          return ResponseEntity.ok(new ProductDTO(product));
      }
        throw new ProductNotFoundException();
    }
}
