package com.scaler.fakestoreapiproxy.Controller;

import com.scaler.fakestoreapiproxy.Common.Authcommon;
import com.scaler.fakestoreapiproxy.DTOs.FakeStoreRequestDto;
import com.scaler.fakestoreapiproxy.DTOs.UserDto;
import com.scaler.fakestoreapiproxy.Exceptions.ProductNotFoundException.ProductNotFoundException;
import com.scaler.fakestoreapiproxy.Models.Product;
import com.scaler.fakestoreapiproxy.Services.FakeStoreProductService;
import com.scaler.fakestoreapiproxy.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    private Authcommon authcommon;
    public ProductController(ProductService productService,Authcommon authcommon){

        this.productService=productService;
        this.authcommon=authcommon;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id,@RequestHeader("Authorization")String auth) throws ProductNotFoundException {
        //UserDto user=authcommon.validate(auth);

        //if(user!=null) {
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
       // }
        //return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
//    @GetMapping("/")
//    public ResponseEntity<List<Product>> getAllProducts(){
//        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
//    }
    @GetMapping("/")
    public Page<Product>getAllProductsbypage(@RequestParam("pageNumber")int pageNumber,
                                        @RequestParam("pageSize")int pageSize){
        return productService.getAllProductsbypage(pageNumber,pageSize);
    }
    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){// we will pass info via request body in postman since sometimes we cannot pass much info via urls so concept of request body came in.
        return productService.createProduct(product);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
