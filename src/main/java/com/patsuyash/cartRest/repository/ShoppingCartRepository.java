package com.patsuyash.cartRest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.patsuyash.cartRest.domain.ShoppingCart;

/**
 * @author Suyash
 *
 */
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
	List<ShoppingCart> findByStatus(String status);
}
