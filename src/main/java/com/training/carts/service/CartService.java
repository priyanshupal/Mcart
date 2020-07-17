package com.training.carts.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.training.carts.entity.Cart;
import com.training.carts.exception.MCartException;

public interface CartService {

	public void addCart(Cart cart);
	
	public List<Cart> getFullCart();

	public List<Cart> getCartByUser(String username);
	
	public String createCart(String json) throws JsonMappingException, JsonProcessingException, MCartException;
	
	public String updateCart(String json) throws JsonMappingException, JsonProcessingException, MCartException;
	
	public void closeCart(String username);
	
	public void deleteCart(int cartId, int productId);
}
