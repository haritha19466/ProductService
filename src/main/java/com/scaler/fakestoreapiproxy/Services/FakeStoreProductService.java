package com.scaler.fakestoreapiproxy.Services;

import com.scaler.fakestoreapiproxy.DTOs.FakeStoreRequestDto;
import com.scaler.fakestoreapiproxy.DTOs.FakeStoreResponseDto;
import com.scaler.fakestoreapiproxy.Exceptions.ProductNotFoundException.ProductNotFoundException;
import com.scaler.fakestoreapiproxy.Models.Category;
import com.scaler.fakestoreapiproxy.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        /* for retrieving products, since it is third party api, we dont know in format we have data so we have to convert
        that to understandable format of client i.e, product class where as 3rd party apis' understandable format is fakestoreapidto format.
         */
        //System.out.println("entered getproduct");
        String url = "https://fakestoreapi.com/products/" + id;
        FakeStoreResponseDto fdto=restTemplate.getForObject(url, FakeStoreResponseDto.class);
        if(fdto==null){
            throw new ProductNotFoundException("Product not found");
        }
        else{
            return convertFakeStoreDtotoProduct(fdto);
        }
    }
    public Product convertFakeStoreDtotoProduct(FakeStoreResponseDto fdto){
        //0System.out.println(fdto.getDescription());
        Product p=new Product();
        //p.setId(fdto.getId());
        p.setTitle(fdto.getTitle());
        p.setDescription(fdto.getDescription());
        p.setPrice(fdto.getPrice());
        p.setImage(fdto.getImage());
        Category c=new Category();
        //c.setId(fdto.getId());
        c.setCategory(fdto.getCategory());
        p.setCategory(c);
        return p;
    }
    public FakeStoreRequestDto convertProducttoRequestdto(Product p){
        FakeStoreRequestDto fdto=new FakeStoreRequestDto();
        fdto.setDescription(p.getDescription());
        fdto.setCategory(p.getCategory().getCategory());
        fdto.setTitle(p.getTitle());
        fdto.setPrice(p.getPrice());
        fdto.setImage(p.getImage());
        return fdto;
    }
    @Override
    public Product updateProduct(long id,Product product) {
        FakeStoreRequestDto RequestDto=convertProducttoRequestdto(product);
        try{
            restTemplate.put("https://fakestoreapi.com/products/"+id,RequestDto);
            System.out.println("Product updated");
        }
        catch(Exception e){
            System.out.println("error occured");
        }
        return product;
    }

    @Override
    public void deleteProduct(long id) {
        try {
            restTemplate.delete("https://fakestoreapi.com/products/" + id);
            System.out.println("Product deleted");
        }
        catch(Exception e){
            System.out.println("Error occured while deleting object");
        }
    }

    @Override
    public Product createProduct(Product product){
        /* Internal working of creating product is when client tries to create a product, he wll enter his udnerstandable format
        of product model but since we are working with 3rd party api we have to covert it into api understanddable format
        so that is FakestoreRequestdto we have cretaed for)
         */
        FakeStoreRequestDto RequestDto=convertProducttoRequestdto(product);
        FakeStoreResponseDto responseDto=restTemplate.postForObject("https://fakestoreapi.com/products",RequestDto,FakeStoreResponseDto.class);
        if(responseDto==null){
            throw new RuntimeException("Product is null");
        }
        else{
            return convertFakeStoreDtotoProduct(responseDto);
        }

    }

    @Override
    public List<Product> getAllProducts() {
        String url = "https://fakestoreapi.com/products/";
        FakeStoreResponseDto[] fdto=restTemplate.getForObject(url, FakeStoreResponseDto[].class);
        Product[] products=new Product[fdto.length];
        for(int i=0;i<fdto.length;i++){
            products[i]=convertFakeStoreDtotoProduct(fdto[i]);
        }
        return List.of(products);
    }
}
