package com.patsuyash.cartRest.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patsuyash.cartRest.domain.Product;
import com.patsuyash.cartRest.domain.ShoppingCart;
import com.patsuyash.cartRest.dto.ShoppingCartDTO;
import com.patsuyash.cartRest.repository.ProductRepository;
import com.patsuyash.cartRest.repository.ShoppingCartRepository;
import com.patsuyash.cartRest.repository.UserRepository;

/**
 * @author Suyash
 *
 */
@Service
@Transactional
public class ShoppingCartService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	public ShoppingCart saveProducts(ShoppingCartDTO shoppingCartDTO) {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product product = productRepository.findOne(shoppingCartDTO.getProductId());
		shoppingCart.setProduct(product);
		shoppingCart.setUser(userRepository.findOne("1"));
		shoppingCart.setStatus(shoppingCartDTO.getStatus());
		shoppingCart.setDate(new Date());
		shoppingCart.setStock(shoppingCartDTO.getStock());
		shoppingCart.setAmount(product.getUnitPrice() * shoppingCartDTO.getStock());

		return shoppingCartRepository.save(shoppingCart);
	}

	public List<ShoppingCart> findAll() {
		return shoppingCartRepository.findByStatus("NOT_PURCHASED");
	}

	public ShoppingCart updateProduct(ShoppingCartDTO shoppingCartDTO, String id) {
		ShoppingCart updateItem = shoppingCartRepository.findOne(id);
		updateItem.setStock(shoppingCartDTO.getStock());
		updateItem.setAmount(updateItem.getProduct().getUnitPrice() * shoppingCartDTO.getStock());
		return shoppingCartRepository.save(updateItem);
	}

	public void deleteProduct(String id) {
		shoppingCartRepository.delete(id);
	}

	public void clearShoppingCart(Object object) {
		shoppingCartRepository.delete(findAll());
	}

	public List<ShoppingCart> findByPurchased() {
		return shoppingCartRepository.findByStatus("PURCHASED");
	}

	public void purchaseProducts(String id) {
		ShoppingCart shoppingCart = shoppingCartRepository.findOne(id);
		shoppingCart.setStatus("PURCHASED");
		shoppingCartRepository.save(shoppingCart);
	}
}
