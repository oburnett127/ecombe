package com.oburnett127.ecom.util;

import com.oburnett127.ecom.model.PurchaseDetails;
import com.oburnett127.ecom.repository.PurchaseDetailsRepositoryImpl;
import com.oburnett127.ecom.service.PurchaseDetailsServiceImpl;
import com.oburnett127.ecom.controller.PurchaseDetailsController;

public class PurchaseDetailsMediator {

	public PurchaseDetails getPurchaseDetails(int purchaseId) {
		PurchaseDetailsController purchaseDetailsController = new PurchaseDetailsController();
		purchaseDetailsController.setPurchaseDetailsService();
		PurchaseDetailsServiceImpl purchaseDetailsServiceImpl = new PurchaseDetailsServiceImpl();
		purchaseDetailsServiceImpl.setPurchaseDetailsRepository();
		PurchaseDetails purchaseDetails = purchaseDetailsController.getPurchaseDetails(purchaseId);
		
		return purchaseDetails;
	}
	
	public void createPurchaseDetails(PurchaseDetails purchaseDetails) {
		PurchaseDetailsRepositoryImpl purchaseDetailsRepositoryImpl = new PurchaseDetailsRepositoryImpl();
		purchaseDetailsRepositoryImpl.createPurchaseDetails(purchaseDetails);
	}
}