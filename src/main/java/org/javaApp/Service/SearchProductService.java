package org.javaApp.Service;

import org.javaApp.Model.Product;
import org.javaApp.Model.ProductDTO;
import org.javaApp.Repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchProductService implements Query<String, List<ProductDTO>> {
    private final ProductRepository productRepository;

    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(String name) {
        List<Product> products = productRepository.findByNameContaining(name);
        products.forEach(product -> System.out.println("Product fetched:" +  product));
        System.out.println("Size of products" + products.size());
        List<ProductDTO> productDTOs = products.stream().map(ProductDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
    }
}
