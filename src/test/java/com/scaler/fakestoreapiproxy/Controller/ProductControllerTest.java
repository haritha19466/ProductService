package com.scaler.fakestoreapiproxy.Controller;

import com.scaler.fakestoreapiproxy.Exceptions.ProductNotFoundException.ProductNotFoundException;
import com.scaler.fakestoreapiproxy.Models.Product;
import com.scaler.fakestoreapiproxy.Services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;
    @MockBean
    private ProductService productService;
    @Test
    public void TestgetProductById() throws ProductNotFoundException {
       Product p=new Product();
       p.setId(123L);
       when(productService.getProductById(123L)).thenReturn(p);
        ResponseEntity<Product>ExpectedresponseEntity=new ResponseEntity<>(p, HttpStatus.OK);
        ResponseEntity<Product>Actualresponse=productController.getProductById(123L,"vaj");
        assertEquals(ExpectedresponseEntity,Actualresponse);
    }
    @Test
    public void TestProductByError() throws ProductNotFoundException{
        //For this we have untagged exception advice tag, please note that.
        ProductNotFoundException productNotFoundException=new ProductNotFoundException("Product not found");
        when(productService.getProductById(234L)).thenThrow(productNotFoundException);
        assertThrows(ProductNotFoundException.class,()->productController.getProductById(234L,"ajsahj"));
    }
    @Test
    public void TestAllproducts(){
        List<Product> productList = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1L);
        Product p2 = new Product();
        p2.setId(2L);
        productList.add(p1);
        productList.add(p2);
        //List<Product>actualResponse=new ArrayList<>();
        when(productService.getAllProducts()).thenReturn(productList);

        ResponseEntity<List<Product>> expectedResponse = new ResponseEntity<>(productList, HttpStatus.OK);
        ResponseEntity<List<Product>> actualResponse = productController.getAllProducts();

        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }
}