package org.javaApp.Service;

import org.javaApp.Exceptions.ProductNotFoundException;
import org.javaApp.Model.Product;
import org.javaApp.Model.ProductDTO;
import org.javaApp.Repository.ProductRepository;
import org.javaApp.Validators.ProductValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {
    private static final Logger logger = LoggerFactory.getLogger(CreateProductService.class);

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
        logger.info("Executing" + getClass() + " input" + product);
        ProductValidation.execute(product);
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }
}
