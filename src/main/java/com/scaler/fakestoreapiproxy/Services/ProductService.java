package com.scaler.fakestoreapiproxy.Services;

import com.scaler.fakestoreapiproxy.Exceptions.ProductNotFoundException.ProductNotFoundException;
import com.scaler.fakestoreapiproxy.Models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public Product getProductById(long id) throws ProductNotFoundException;

    //public List<Product> getAllProducts();

    public Product updateProduct(long id,Product product);

    public Product createProduct(Product product);

    public void deleteProduct(long id);
    public Page<Product> getAllProductsbypage(int PageSize, int PageNumber);
}
