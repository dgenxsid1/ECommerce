package org.javaApp.Controller;
import org.javaApp.Model.Product;
import org.javaApp.Model.ProductDTO;
import org.javaApp.Model.UpdateProductCommand;
import org.javaApp.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final CreateProductService createProductService;
    private final GetProductsService getProductsService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;
    private final GetProductService getProductService;
    private final SearchProductService searchProductService;
    @Autowired
    public ProductController(CreateProductService createProductService, GetProductsService getProductsService,
                             UpdateProductService updateProductService, DeleteProductService deleteProductService,
             GetProductService getProductService, SearchProductService searchProductService) {
        this.createProductService = createProductService;
        this.getProductsService = getProductsService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
        this.getProductService =  getProductService;
        this.searchProductService = searchProductService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product){
        return createProductService.execute(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProducts(){
        return getProductsService.execute(null);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Integer id){
        return getProductService.execute(id);
    }

    @GetMapping("/product/search")
    public ResponseEntity<List<ProductDTO>> searchProductByName(@RequestParam("name") String name){
        return searchProductService.execute(name);
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product){
        return updateProductService.execute(new UpdateProductCommand(id, product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id){
        return deleteProductService.execute(id);
    }

    @GetMapping("/product/searchPriceRange")
    public ResponseEntity<List<ProductDTO>> searchByPriceBetweenTwoPrices(@RequestParam("minPrice") Double minPrice, @RequestParam("maxPrice") Double maxPrice){
        return searchProductService.searchByPriceBetween(minPrice, maxPrice);
    }


}
/*

Spring tries to bind the {id} placeholder in the URL to the id method parameter. To do this, it depends on two things:

Parameter Name Metadata: The compiler must include parameter name metadata in the .class files (enabled via the -parameters flag). Without this, the parameter's name (id) is not available during runtime.
Reflection: Spring looks for metadata to match the URL variable {id} to the method's parameter id.
If the compiler didn't use the -parameters flag, Spring doesn’t know that the URL's {id} corresponds to the method parameter id. This causes an IllegalArgumentException.


you provide Spring with a direct mapping. Spring doesn't need to infer the parameter name; it knows that the id in the URL matches the method parameter.

How Spring Processes This:
The @PathVariable("id") annotation explicitly maps the {id} from the URL to the id parameter.
Spring no longer depends on the compiler's parameter name metadata or reflection.
The mapping works regardless of whether the -parameters flag is used.
 */