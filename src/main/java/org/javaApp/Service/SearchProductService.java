package org.javaApp.Service;

import org.javaApp.Exceptions.ProductNotFoundException;
import org.javaApp.Model.Product;
import org.javaApp.Model.ProductDTO;
import org.javaApp.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchProductService implements Query<String, List<ProductDTO>> {
    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(SearchProductService.class);


    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(String name) {
        logger.info("Executing" + getClass() + " input" + name);
        List<Product> products = productRepository.findByNameContaining(name);
        products.forEach(product -> System.out.println("Product fetched:" +  product));
        System.out.println("Size of products" + products.size());
        List<ProductDTO> productDTOs = products.stream().map(ProductDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
    }

    public ResponseEntity<List<ProductDTO>> searchByNameOrDescription(String keyword){
        List<Product> products = productRepository.findByNameOrDescriptionContaining(keyword);
        products.forEach(product -> System.out.println("Products fetched:" + product));
        List<ProductDTO> productDTOS = products.stream().map(ProductDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOS);
    }

    public ResponseEntity<List<ProductDTO>> searchByPriceBetween (Double minPrice, Double maxPrice){
        List<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice);
        products.forEach(product -> System.out.println("Products fetched:" + product));
        List<ProductDTO> productDTOS = products.stream().map(ProductDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOS);
    }
}
