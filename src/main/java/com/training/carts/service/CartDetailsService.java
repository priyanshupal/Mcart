package com.training.carts.service;

import java.util.List;

import com.training.carts.entity.CartDetails;

public interface CartDetailsService {
	public void addCartDetails(CartDetails cartDetails);
	
	public List<CartDetails> getFullCart();
	
	public void deleteCart(int cartId, int productId);
}
