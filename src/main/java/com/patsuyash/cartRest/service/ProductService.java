package com.patsuyash.cartRest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patsuyash.cartRest.domain.Product;
import com.patsuyash.cartRest.repository.ProductRepository;

/**
 * @author Suyash
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	private static List<Product> products = new ArrayList<>();

	static {
		products.add(new Product("1", 35.75d, 1000, "Pears baby soap for Kids", "Soap"));
		products.add(new Product("2", 45.50d, 500, "Signal Tooth Brushes Size in (L, M, S)", "Tooth Brushe"));
		products.add(new Product("3", 1500.0d, 100, "Casual Shirt imported from France", "Shirt"));
		products.add(new Product("4", 1000.0d, 400, "Leather bag imported from USA ", "Office Bag"));
		products.add(new Product("5", 450.0d, 800, "Hot Water Bottles", "Bottle"));
		products.add(new Product("6", 2500.0d, 800, "Imported wrist watches from swiss", "Wrist Watch"));
		products.add(new Product("7", 45000.0d, 800, "3G/4G capability", "Mobile Phone"));
		products.add(new Product("8", 300.0d, 800, "Head and Shoulders Shampoo", "Shampoo"));
		products.add(new Product("9", 550.0d, 800, "Imported Leather Wallets from AUS", "Leather Wallets"));
		products.add(new Product("10", 85000.0d, 800, "Imported Canon camera from USA", "Camera"));
	}

	public void saveInitialBatch() {
		productRepository.save(products);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

}
