package com.example.product_service.controller;

import com.example.product_service.dto.ProductReponse;
import com.example.product_service.dto.ProductRequest;
import com.example.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductReponse createProduct(@RequestBody ProductRequest product) {
        return productService.createProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductReponse> getAllProducts() {
//        try{
//            Thread.sleep(5000);
//        }catch (InterruptedException e){
//            log.info("Test long request");
//        }
        return productService.getAllProducts();
    }
}
