package com.oburnett127.ecom.service;

import java.util.List;

import com.oburnett127.ecom.model.Purchase;

public interface PurchaseService {

	Purchase createPurchase(Purchase Purchase);
	
	List<Purchase> getPurchases();
	
	Purchase getPurchase(Integer id);

//	Purchase updatePurchase(Purchase Purchase);

	void deletePurchase(Integer id);

}