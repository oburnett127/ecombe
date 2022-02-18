package com.oburnett127.ecom.service;

import com.oburnett127.ecom.model.Cart;

public interface CartService {

	Cart createCart(Cart Cart);
	
	Cart getCart(Integer id);
	
	//List<Cart> getCarts();

	//Cart updateCart(Cart Cart);

	//void deleteCart(Integer id);

}