package com.patsuyash.cartRest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.patsuyash.cartRest.domain.Product;

/**
 * @author Suyash
 *
 */
public interface ProductRepository extends MongoRepository<Product, String> {

}
