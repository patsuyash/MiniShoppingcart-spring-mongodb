package com.patsuyash.cartRest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.patsuyash.cartRest.domain.User;

/**
 * @author Suyash
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
}
