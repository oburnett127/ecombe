package com.oburnett127.ecom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.oburnett127.ecom.model.Product;
import com.oburnett127.ecom.service.ProductService;
import com.oburnett127.ecom.util.ServiceError;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public @ResponseBody Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public @ResponseBody ModelMap getProducts(HttpServletResponse httpResponse, ModelMap model) {
		List<Product> productList = productService.getProducts();
		model.addAttribute("products", productList);
		httpResponse.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		httpResponse.setHeader("Location", "http://localhost:8080/ecom/products.jsp");
		return model;
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable(value="id") Integer id) {
		return productService.getProduct(id);
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.PUT)
	public @ResponseBody Product updateProduct(@RequestBody Product Product) {
		return productService.updateProduct(Product);
	}
	
	@RequestMapping(value = "/product/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Object delete(@PathVariable(value="id") Integer id) {
		productService.deleteProduct(id);
		return null;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}