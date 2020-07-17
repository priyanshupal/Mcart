package com.training.carts.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.carts.entity.CartDetails;
import com.training.carts.repository.CartDetailsRepository;


@Transactional
@Service("cartDetailsService")
public class CartDetailsServiceImpl implements CartDetailsService {
	
	@Autowired
	private CartDetailsRepository cartDetailsRepository;
	
	public void addCartDetails(CartDetails cartDetails) {
		cartDetailsRepository.saveAndFlush(cartDetails);
	}
	
	public List<CartDetails> getFullCart() {
		return cartDetailsRepository.findAll();
	}
	
	@Transactional
	public void deleteCart(int cartId, int productId) {
		cartDetailsRepository.deleteCart(cartId, productId);
	}
}
