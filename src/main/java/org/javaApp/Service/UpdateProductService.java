package org.javaApp.Service;

import org.javaApp.Model.Product;
import org.javaApp.Model.ProductDTO;
import org.javaApp.Model.UpdateProductCommand;
import org.javaApp.Repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO>{

    private ProductRepository productRepository;
    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
      Optional<Product> productOptional = productRepository.findById(command.getId());
      if(productOptional.isPresent()){
          Product product = command.getProduct();
          product.setId(command.getId());
          productRepository.save(product);
          return ResponseEntity.ok(new ProductDTO(product));
      }
      return null;
    }
}
