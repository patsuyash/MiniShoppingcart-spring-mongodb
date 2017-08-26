package com.patsuyash.cartRest.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Suyash
 *
 */
@Document(collection = "Product")
public class Product implements Serializable {

	@Id
	private String id;

	private String name;

	private String description;

	private Integer quantity;

	private Double unitPrice;

	@DBRef
	private Set<ShoppingCart> shoppingCarts = new HashSet<>();

	public Product() {

	}

	@PersistenceConstructor
	public Product(String id, Double unitPrice, Integer quantity, String description, String name) {
		this.id = id;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.description = description;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
