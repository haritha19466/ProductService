package com.scaler.fakestoreapiproxy.Services;

import com.scaler.fakestoreapiproxy.Exceptions.ProductNotFoundException.ProductNotFoundException;
import com.scaler.fakestoreapiproxy.Models.Category;
import com.scaler.fakestoreapiproxy.Models.Product;
import com.scaler.fakestoreapiproxy.repos.Categoryrepo;
import com.scaler.fakestoreapiproxy.repos.Productrepo;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Primary
public class SelfProductService implements ProductService{
    Productrepo productrepo;
    Categoryrepo categoryrepo;
    public SelfProductService(Productrepo productrepo,Categoryrepo categoryrepo){
        this.productrepo=productrepo;
        this.categoryrepo=categoryrepo;
    }
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        Optional<Product>optionalProduct=productrepo.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product not found");
        }
        else{
            return optionalProduct.get();
        }
    }

//    @Override
//    public List<Product> getAllProducts() {
//
//        return null;
//    }
    @Override
    public Page<Product> getAllProductsbypage(int PageNumber, int PageSize) {
        return productrepo.findAll(PageRequest.of(PageNumber,PageSize
                ,Sort.by("price").ascending()));
    }
    @Override
    public Product updateProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category categoryob=product.getCategory();
        if(categoryob.getCategory()==null){
            throw new RuntimeException("Enter Category details");
        }
        else{
            //checking if it is a new category if it is,creating category object otherwise
            //sending exisitng object reference of category.
            Optional<Category>optionalCategory=categoryrepo.findBycategory(categoryob.getCategory());
            if(optionalCategory.isEmpty()){
                categoryrepo.save(categoryob);
            }
            else{
                product.setCategory(optionalCategory.get());
            }
        }
        Product savedproduct=productrepo.save(product);
        return savedproduct;
    }

    @Override
    public void deleteProduct(long id) {

    }
}
