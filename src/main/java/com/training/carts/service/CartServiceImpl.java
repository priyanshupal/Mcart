package com.training.carts.service;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.training.carts.entity.Cart;
import com.training.carts.entity.CartDetails;
import com.training.carts.entity.CartDetailsPK;
import com.training.carts.exception.MCartException;
import com.training.carts.repository.CartRepository;

@Service("cartService")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private CartService cartService;
	
	@Autowired 
	private CartDetailsService cartDetailsService;
	
	public void addCart(Cart cart) {
		cartRepository.saveAndFlush(cart);
	}
	
	public List<Cart> getFullCart() {
		return cartRepository.findAll();
	}

	public List<Cart> getCartByUser(String username) {
		return cartRepository.getCartByUser(username);
	}

	public String createCart(String json) throws JsonMappingException, JsonProcessingException, MCartException {
		ObjectNode node = mapper.readValue(json, ObjectNode.class);
		List<Cart> tempCart = cartService.getCartByUser(node.get("username").asText());
		if (!tempCart.isEmpty()) {
			throw new MCartException("User's cart is already available, append to the same cart");
		}
		else {
			Cart cart = new Cart();
			cart.setUsername(node.get("username").asText());
			cart.setDateOfCreation(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			cart.setDateOfModification(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			cart.setStatusOfCart("Open");
			cartService.addCart(cart);
			for (JsonNode temp : node.get("productsInCart")) {
				CartDetails c = new CartDetails();
				CartDetailsPK pk = new CartDetailsPK();
				pk.setCartId(cart.getCartId());
				pk.setProductId(temp.get("productId").asInt());
				c.setProductName(temp.get("productName").asText());
				c.setQuantity(temp.get("quantity").asInt());
				c.setPrice(temp.get("price").asInt());
				c.setCartDetailsPK(pk);
				cartDetailsService.addCartDetails(c);
			}
		}
		tempCart = cartService.getCartByUser(node.get("username").asText());
		return ("New items got inserted into the cart with the ID : " + tempCart.get(0).getCartId());
	}
	
	public String updateCart(String json) throws JsonMappingException, JsonProcessingException, MCartException {
		ObjectNode node = mapper.readValue(json, ObjectNode.class);
		List<Cart> carts = cartService.getCartByUser(node.get("username").asText());
		if (carts.isEmpty()) {
			throw new MCartException("User's cart is not available");
		}
		else {
			Cart cart = carts.get(0);
			cart.setDateOfModification(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			cart.setStatusOfCart("Open");
			cartService.addCart(cart);
			for (JsonNode temp : node.get("productsInCart")) {
				CartDetails c = new CartDetails();
				CartDetailsPK pk = new CartDetailsPK();
				pk.setCartId(cart.getCartId());
				pk.setProductId(temp.get("productId").asInt());
				c.setProductName(temp.get("productName").asText());
				c.setQuantity(temp.get("quantity").asInt());
				c.setPrice(temp.get("price").asInt());
				c.setCartDetailsPK(pk);
				cartDetailsService.addCartDetails(c);
			}
			return ("CartID: " + cart.getCartId() +" updated");
		}
	}
	
	@Transactional
	public void closeCart(String username) {
		cartRepository.closeCart(username);
	}
	
	@Transactional
	public void deleteCart(int cartId, int productId) {
		cartDetailsService.deleteCart(cartId, productId);
	}
}
