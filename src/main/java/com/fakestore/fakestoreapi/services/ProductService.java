package com.fakestore.fakestoreapi.services;

import com.fakestore.fakestoreapi.exceptions.ProductNotFoundException;
import com.fakestore.fakestoreapi.models.Product;
import com.fakestore.fakestoreapi.repositories.projection.ProductProjection;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product addNewProduct(Product product);
    Product updateProduct(Long id, Product product) throws ProductNotFoundException;
    Product replaceProduct(Long id, Product product) throws ProductNotFoundException;
    boolean deleteProduct(Long id) throws ProductNotFoundException;
}
