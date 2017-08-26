package com.patsuyash.cartRest.dto;

/**
 * @author Suyash
 *
 */
public class ShoppingCartDTO {
	private String productId;
	private Integer stock;
	private String status;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
