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
public class GetProductsService implements Query<Void, List<ProductDTO>> {

    /*
    @Autowired
    private ProductRepository productRepository;
    //This will work but we will replace field injection with constructor injection
    */

    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(GetProductsService.class);


    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        logger.info("Executing" + getClass());
        List<Product> products = productRepository.findAll();
        System.out.println("The size of products:" + products.size());
        products.forEach(product -> System.out.println("Product fetched:" +  product));
        List<ProductDTO> productDTOs = products.stream().map(ProductDTO::new).toList();    //mapping step
        return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
    }
}