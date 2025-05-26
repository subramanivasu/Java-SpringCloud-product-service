package com.project.ecommerce.microservices.repository;

import com.project.ecommerce.microservices.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {


}
