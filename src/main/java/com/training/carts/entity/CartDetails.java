package com.training.carts.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cart_details")
public class CartDetails {

	@EmbeddedId
	private CartDetailsPK cartDetailsPK;

	@Column
	private String productName;
	
	@Column
	private int quantity;
	
	@Column
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public CartDetailsPK getCartDetailsPK() {
		return cartDetailsPK;
	}

	public void setCartDetailsPK(CartDetailsPK cartDetailsPK) {
		this.cartDetailsPK = cartDetailsPK;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
