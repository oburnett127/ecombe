package com.oburnett127.ecom.service;

import java.util.List;

import com.oburnett127.ecom.model.BillingInfo;

public interface BillingInfoService {

	BillingInfo createBillingInfo(BillingInfo BillingInfo);
	
	List<BillingInfo> getBillingInfos();
	
	BillingInfo getBillingInfo(Integer id);

	BillingInfo updateBillingInfo(BillingInfo BillingInfo);

	void deleteBillingInfo(Integer id);

}