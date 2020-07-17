package com.training.carts.dto;

import java.sql.Date;

import com.training.carts.entity.Cart;

public class CartDTO {

	private int cartId;
	
	private String username;
	
	private Date dateOfCreation;
	
	private Date dateOfModification;
	
	private String statusOfCart;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public Date getDateOfModification() {
		return dateOfModification;
	}

	public void setDateOfModification(Date dateOfModification) {
		this.dateOfModification = dateOfModification;
	}

	public String getStatusOfCart() {
		return statusOfCart;
	}

	public void setStatusOfCart(String statusOfCart) {
		this.statusOfCart = statusOfCart;
	}

	public Cart createEntity() {
		Cart cart = new Cart();
		cart.setCartId(this.cartId);
		cart.setDateOfCreation(this.dateOfCreation);
		cart.setDateOfModification(this.dateOfCreation);
		cart.setStatusOfCart(this.statusOfCart);
		cart.setUsername(this.username);
		return cart;
	}
	
	public static CartDTO valueOf(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setCartId(cart.getCartId());
		cartDTO.setDateOfCreation(cart.getDateOfCreation());
		cartDTO.setDateOfModification(cart.getDateOfModification());
		cartDTO.setStatusOfCart(cart.getStatusOfCart());
		cartDTO.setUsername(cart.getUsername());
		return cartDTO;
	}
}
