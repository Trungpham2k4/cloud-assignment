package com.example.product_service.service;

import com.example.product_service.dto.ProductReponse;
import com.example.product_service.dto.ProductRequest;
import com.example.product_service.entity.Product;
import com.example.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductReponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created");
        return new ProductReponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
    }

    public List<ProductReponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductReponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()
                )).toList();
    }
}
