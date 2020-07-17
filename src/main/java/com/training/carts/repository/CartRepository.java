package com.training.carts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.carts.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Query(value = "select * from cart where username = ? and status_of_cart = 'Open'", nativeQuery=true)
	public List<Cart> getCartByUser(String username);
	
	@Modifying
	@Query(value = "update cart set status_of_cart='Closed' where username = ?", nativeQuery = true)
	public void closeCart(String username);
}
