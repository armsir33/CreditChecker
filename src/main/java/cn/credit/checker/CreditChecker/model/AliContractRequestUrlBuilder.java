package cn.credit.checker.CreditChecker.model;

import java.net.URI;
import java.net.URISyntaxException;

public class AliContractRequestUrlBuilder extends AliRequestUrlBuilder {

	private String productCode;
	private String contractName;
	private String contractFile;

    public void productCode(final String productCode) {
        builder.setParameter("product_code", productCode);
    }

    public void contractName(final String contractName) {
        builder.setParameter("contract_name", contractName);
    }

    public void contractFile(final String contractFile) {
        builder.setParameter("contract_file", contractFile);
    }

    @Override
    public URI build() throws URISyntaxException {
        return builder.build();
    }
}
