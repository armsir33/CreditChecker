package cn.credit.checker.CreditChecker.dto;

import java.net.URI;
import java.net.URISyntaxException;

public class AliContractRequestUriBuilder extends AliRequestUriBuilder {

	public URI build() throws URISyntaxException {
		return this.builder.build();
	}
	
	public void productCode(final String productCode) {
		builder.setParameter("product_code", productCode);
	}
	
	public void contractName(final String contractName) {
		builder.setParameter("contract_name", contractName);
	}
	
	public void contractFile(final String contractFile) {
		builder.setParameter("contract_file", contractFile);
	}
	
	
}
