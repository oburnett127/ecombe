package com.oburnett127.ecom.repository;

import java.util.List;
import com.oburnett127.ecom.model.Purchase;

public interface PurchaseRepository {

	Purchase createPurchase(Purchase purchase);
	
	List<Purchase> getPurchases();

	Purchase getPurchase(Integer id);

	//Purchase updatePurchase(Purchase purchase);

	void deletePurchase(Integer id);
}