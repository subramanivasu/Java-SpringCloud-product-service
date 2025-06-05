package com.project.ecommerce.microservices.service;


import com.project.ecommerce.microservices.dto.ProductRequest;
import com.project.ecommerce.microservices.dto.ProductResponse;
import com.project.ecommerce.microservices.model.Product;
import com.project.ecommerce.microservices.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .skuCode(productRequest.skuCode())
                .build();
        productRepository.save(product);
        ProductResponse productResponse = new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSkuCode()
        );
        log.info("Product {} is saved", product.getId());
        return productResponse;

    }

    public List<ProductResponse> getAllProducts(){
        log.info("Fetching all products");
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getSkuCode()))
                .toList();

    }

}
