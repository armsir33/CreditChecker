package cn.credit.checker.CreditChecker.service;

import cn.credit.checker.CreditChecker.config.CreditCheckerConfigProperty;
import cn.credit.checker.CreditChecker.dto.CreditCheckerRequest;
import cn.credit.checker.CreditChecker.dto.CreditCheckerResponse;
import cn.credit.checker.CreditChecker.model.AliContractRequestUrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreditCheckerService {

	@Autowired
	private CreditCheckerConfigProperty configProperty;

	public ResponseEntity<CreditCheckerResponse> initiateContract(CreditCheckerRequest request) {
		final AliContractRequestUrlBuilder builder = new AliContractRequestUrlBuilder();
		builder.appId(configProperty.getAppId());

		final CreditCheckerResponse response = new CreditCheckerResponse();
		response.setAppId(configProperty.getAppId());
		response.setProductCode(request.getProductCode());
		response.setContractName(request.getContractName());
		response.setContractFile(request.getContractFile());
		return new ResponseEntity<CreditCheckerResponse>(response, HttpStatus.OK);
	}

	public void initiateCertification() {

	}

	public void certifyCertification() {

	}

	public void queryCertification() {

	}
}
