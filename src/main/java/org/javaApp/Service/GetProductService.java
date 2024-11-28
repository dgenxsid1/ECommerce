package org.javaApp.Service;

import org.javaApp.Model.Product;
import org.javaApp.Model.ProductDTO;
import org.javaApp.Repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {
    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        //accounts for null value if dB can't find it
        Optional<Product> productOptional = productRepository.findById(input);

        /*
         return productOptional.map(product -> ResponseEntity.ok(new ProductDTO(product))).orElse(null);
         functional way to do the bottom logic
        */

        if (productOptional.isPresent()) {
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }
        return null;
    }
}

