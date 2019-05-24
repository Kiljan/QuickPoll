package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.service.CartService;

@RestController
public class CartRestController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/carts", method = RequestMethod.GET)
	public void insertCart() {
		cartService.insertCArt();
	}
	
}
