package com.oburnett127.ecom.repository;

import java.util.List;
import com.oburnett127.ecom.model.Product;

public interface ProductRepository {

	Product createProduct(Product product);
	
	List<Product> getProducts();

	Product getProduct(Integer id);

	Product updateProduct(Product product);

	void deleteProduct(Integer id);
}