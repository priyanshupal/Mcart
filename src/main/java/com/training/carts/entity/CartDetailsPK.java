package com.training.carts.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartDetailsPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "cart_id")
	private int CartId;
	
	@Column(name = "product_id")
	private int ProductId;

	public int getCartId() {
		return CartId;
	}

	public void setCartId(int cartId) {
		CartId = cartId;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}
	
	
	
}
