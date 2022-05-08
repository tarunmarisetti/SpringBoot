package com.example.SpringbootsearchAPI.controller;

import com.example.SpringbootsearchAPI.entity.Product;
import com.example.SpringbootsearchAPI.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //create a new product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody  Product product){
         productService.createProduct(product);
        URI location = URI.create(String.format("/Products/%s", product.getName()));
        return ResponseEntity.created(location).build();
    }

//    get a product
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(productService.searchProducts(query));
    }

//    getAllProducts
    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());

    }

//    Update a Product details
    @PatchMapping("/updateProduct")
   public ResponseEntity<Product> updateAProduct(@RequestParam("Id") Long id,@RequestBody Product product ){
        Product productDetailsToBeModified=productService.getAProduct(id);
        productDetailsToBeModified.setSku(product.getSku());
        productDetailsToBeModified.setActive(false);
        productDetailsToBeModified.setName(product.getName());
        productDetailsToBeModified.setDescription(product.getDescription());
        return ResponseEntity.ok(productDetailsToBeModified);


   }
   @DeleteMapping("/deleteProduct")
   public HttpStatus deleteProduct(@RequestParam("Id") Long id){
        productService.deleteProduct(id);
        return HttpStatus.OK;

   }

}
