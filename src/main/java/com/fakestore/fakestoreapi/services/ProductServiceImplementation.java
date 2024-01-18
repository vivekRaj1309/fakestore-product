package com.fakestore.fakestoreapi.services;

import com.fakestore.fakestoreapi.exceptions.ProductNotFoundException;
import com.fakestore.fakestoreapi.models.Category;
import com.fakestore.fakestoreapi.models.Product;
import com.fakestore.fakestoreapi.repositories.CategoryRepositories;
import com.fakestore.fakestoreapi.repositories.ProductRepositories;
import com.fakestore.fakestoreapi.repositories.projection.ProductProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService{
    public ProductRepositories productRepositories;
    public CategoryRepositories categoryRepositories;

    @Autowired
    public ProductServiceImplementation(ProductRepositories productRepositories, CategoryRepositories categoryRepositories){
        this.productRepositories = productRepositories;
        this.categoryRepositories = categoryRepositories;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepositories.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product not available with id : " + id, "Kindly check different product");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepositories.findAll();
    }

    @Override
    public Product addNewProduct(Product product) {
        Optional<Category> category = categoryRepositories.findByName(product.getCategory().getName());
        if(category.isPresent()){
            product.setCategory(category.get());
        }
        return productRepositories.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Product newProduct = getSingleProduct(id);
        if(product.getTitle() != null){
            newProduct.setTitle(product.getTitle());
        }
        if(product.getPrice() != 0){
            newProduct.setPrice(product.getPrice());
        }
        if(product.getCategory() != null){
            newProduct.setCategory(product.getCategory());
        }
        if(product.getDescription() != null){
            newProduct.setDescription(product.getDescription());
        }
        if(product.getImageUrl() != null){
            newProduct.setImageUrl(product.getImageUrl());
        }
        return addNewProduct(newProduct);
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        Product newProduct = getSingleProduct(id);
        newProduct.setCreatedAt(product.getCreatedAt());
        newProduct.setUpdatedAt(product.getUpdatedAt());
        newProduct.setTitle(product.getTitle());
        newProduct.setPrice(product.getPrice());
        newProduct.setCategory(product.getCategory());
        newProduct.setDescription(product.getDescription());
        newProduct.setImageUrl(product.getImageUrl());
        return addNewProduct(newProduct);
    }

    @Override
    public boolean deleteProduct(Long id) throws ProductNotFoundException {
        Product product = getSingleProduct(id);
        productRepositories.delete(product);
        return true;
    }
}
