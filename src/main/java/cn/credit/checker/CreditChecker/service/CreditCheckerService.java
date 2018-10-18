package cn.credit.checker.CreditChecker.service;

import cn.credit.checker.CreditChecker.dto.CreditCheckerRequest;
import cn.credit.checker.CreditChecker.model.AliContractRequestUrlBuilder;
import org.springframework.stereotype.Service;

@Service
public class CreditCheckerService {

	public void initiateContract(CreditCheckerRequest request) {
		final AliContractRequestUrlBuilder builder = new AliContractRequestUrlBuilder();
//		builder.
	}

	public void initiateCertification() {

	}

	public void certifyCertification() {

	}

	public void queryCertification() {

	}
}
