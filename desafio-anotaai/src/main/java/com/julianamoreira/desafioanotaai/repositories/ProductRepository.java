package com.julianamoreira.desafioanotaai.repositories;

import com.julianamoreira.desafioanotaai.domain.category.Category;
import com.julianamoreira.desafioanotaai.domain.products.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Products, String> {
}
