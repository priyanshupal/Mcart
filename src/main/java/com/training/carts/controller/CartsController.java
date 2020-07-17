
package com.training.carts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.training.carts.entity.Cart;
import com.training.carts.exception.MCartException;
import com.training.carts.service.CartService;

@RestController
@CrossOrigin
public class CartsController {
	
	@Autowired
	private CartService cartService;
	
//	@GetMapping(value = "/carts", produces = "application/json")
//	public ResponseEntity<List<Cart>> getCart() {
//		return ResponseEntity.ok(cartService.getFullCart());
//	}
	
	@GetMapping(value = "/carts", produces = "application/json")
	public ResponseEntity<List<Cart>> getCart(@RequestParam("username") String username) {
		return ResponseEntity.ok(cartService.getCartByUser(username));
	}
	
	@PostMapping(consumes = "application/json", value = "/carts")
	public ResponseEntity<String> createCart(@RequestBody String json) throws JsonMappingException, JsonProcessingException, MCartException {
		return ResponseEntity.ok(cartService.createCart(json));
	}
	
	@PutMapping(consumes = "application/json", value= "/carts")
	public ResponseEntity<String> updateCart(@RequestBody String json) throws JsonMappingException, JsonProcessingException, MCartException {
		return ResponseEntity.ok(cartService.updateCart(json));
	}
	
	@PutMapping(value = "/close")
	public void closeCart(@RequestParam("username") String username) {
		cartService.closeCart(username);
	}
	
	@DeleteMapping(value = "/delete")
	public String deleteCart(@RequestParam("cartId") int cartId, @RequestParam("productId") int productId) {
		cartService.deleteCart(cartId, productId);
		return "Success";
	}
}
