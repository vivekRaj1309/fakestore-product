package com.fakestore.fakestoreapi.controllers;

import com.fakestore.fakestoreapi.exceptions.ProductNotFoundException;
import com.fakestore.fakestoreapi.models.Product;
import com.fakestore.fakestoreapi.repositories.projection.ProductProjection;
import com.fakestore.fakestoreapi.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    public ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(@RequestHeader("AuthenticationToken") String token){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addNewProduct(product), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.replaceProduct(id, product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id")Long id) throws ProductNotFoundException {
        System.out.println(true);
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
