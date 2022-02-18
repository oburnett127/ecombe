package com.oburnett127.ecom.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.oburnett127.ecom.model.BillingInfo;
import com.oburnett127.ecom.util.BillingInfoMediator;
import com.oburnett127.ecom.util.PurchaseDetailsMediator;
import com.oburnett127.ecom.model.Purchase;
import com.oburnett127.ecom.model.PurchaseDetails;

public class PurchaseRowMapper implements RowMapper<Purchase> {
	@Override
	public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(rs.getInt("purchaseId"));
		purchase.setAccountId(rs.getInt("accountId"));
		purchase.setPurchaseDate(rs.getString("purchaseDate"));
		
		PurchaseDetailsMediator purchaseDetailsMediator = new PurchaseDetailsMediator();
		PurchaseDetails purchaseDetails = purchaseDetailsMediator.getPurchaseDetails(purchase.getPurchaseId());
		BillingInfoMediator billingInfoMediator = new BillingInfoMediator();
		BillingInfo billingInfo = billingInfoMediator.getBillingInfo(purchase.getPurchaseId());
		purchase.setPurchaseDetails(purchaseDetails);
		purchase.setBillingInfo(billingInfo);

		return purchase;
	}
}
