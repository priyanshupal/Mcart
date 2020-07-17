package com.training.carts.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private int cartId;
	
	@Column
	private String username;
	
	@Column
	private Date dateOfCreation;
	
	@Column
	private Date dateOfModification;
	
	@Column
	private String statusOfCart;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Set<CartDetails> cartDetails;

	public Set<CartDetails> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(Set<CartDetails> cartDetails) {
		this.cartDetails = cartDetails;
	}

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
	
}
