package com.training.carts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.carts.entity.CartDetails;
import com.training.carts.entity.CartDetailsPK;

@Repository
public interface CartDetailsRepository extends JpaRepository<CartDetails, CartDetailsPK> {

	@Modifying
	@Query(value = "delete from cart_details where cart_id = ? and product_id = ?", nativeQuery = true)
	public void deleteCart(int cartId, int productId);
}
