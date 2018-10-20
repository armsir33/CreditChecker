package cn.credit.checker.CreditChecker.service;

import cn.credit.checker.CreditChecker.config.CreditCheckerConfigProperty;
import cn.credit.checker.CreditChecker.dto.CreditCheckerRequest;
import cn.credit.checker.CreditChecker.dto.CreditCheckerResponse;
import cn.credit.checker.CreditChecker.model.AliContractInitializeRequestUrlBuilder;
import cn.credit.checker.CreditChecker.model.AliContractInitializeResponseWrapper;
import cn.credit.checker.CreditChecker.util.AliClient;
import cn.credit.checker.CreditChecker.util.DateTimeUtil;
import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;

import static cn.credit.checker.CreditChecker.service.AliServiceConstants.*;

@Service
public class CreditCheckerService {

    private static final Logger LOG = LoggerFactory.getLogger(CreditCheckerService.class);
	private static final Gson GSON = new Gson();
    
    @Autowired
	private CreditCheckerConfigProperty configProperty;
    @Autowired
    private AliClient aliClient;

	public ResponseEntity<CreditCheckerResponse> initiateContract(final CreditCheckerRequest request) {
        final URI uri = createAliRequestUrl(request);
        final CloseableHttpResponse response = aliClient.doGet(configProperty.getGateway(), uri);
        verifyResponse(response);
        final AliContractInitializeResponseWrapper aliContractInitializeResponse = parseAliContractInitializeResponse(response);
        final CreditCheckerResponse creditCheckerResponse = convert2CreditCheckResponse(aliContractInitializeResponse);
        return new ResponseEntity<CreditCheckerResponse>(creditCheckerResponse, HttpStatus.OK);
	}

    public void initiateCertification() {

	}

	public void certifyCertification() {

	}

	public void queryCertification() {

	}

    private URI createAliRequestUrl(final CreditCheckerRequest request) {
        final AliContractInitializeRequestUrlBuilder builder = new AliContractInitializeRequestUrlBuilder();
        builder.appId(configProperty.getAppId());
        builder.method(ZHIMA_CONTRACT_INITIALIZE);
        builder.format(ZHIMA_FORMAT);
        builder.charset(ZHIMA_CHARSET);
        builder.signType(ZHIMA_SIGN_TYPE);
        builder.timestamp(DateTimeUtil.getCurrentTimeAsString());
        builder.version(ZHIMA_VERSION);
        builder.bizContent(createBizContent(request));
        return builder.build();
    }

    private AliContractInitializeRequestUrlBuilder.BizContent createBizContent(final CreditCheckerRequest request) {
        final AliContractInitializeRequestUrlBuilder.BizContent bizContent = new AliContractInitializeRequestUrlBuilder.BizContent();
        bizContent.setProductCode(configProperty.getProductCode());
        bizContent.setContractName(request.getContractName());
        bizContent.setContractFile(request.getContractFile());
        return bizContent;
    }

    private void verifyResponse(final CloseableHttpResponse httpResponse) {
        final int statusCode = httpResponse.getStatusLine().getStatusCode();
        if(statusCode != HttpStatus.OK.value() && statusCode != HttpStatus.ACCEPTED.value()) {
            LOG.warn("Received http call with status code {}", statusCode);
            throw new RuntimeException("Received http call with status code " + statusCode);
        }
    }

	private AliContractInitializeResponseWrapper parseAliContractInitializeResponse(final CloseableHttpResponse httpResponse) {
        try {
            final String json = EntityUtils.toString(httpResponse.getEntity());
            LOG.info("Returned json {}", json);
            return GSON.fromJson(json, AliContractInitializeResponseWrapper.class);
        } catch (IOException e) {
            LOG.warn("FAILED to parseAliContractInitializeResponse http entity");
            throw new RuntimeException("FAILED to parseAliContractInitializeResponse http entity", e);
        }
    }

    private CreditCheckerResponse convert2CreditCheckResponse(final AliContractInitializeResponseWrapper response) {
        final CreditCheckerResponse creditCheckerResponse = new CreditCheckerResponse();
        creditCheckerResponse.setCode(response.getZhimaCustomerContractInitializeResponse().getCode());
        creditCheckerResponse.setMsg(response.getZhimaCustomerContractInitializeResponse().getMsg());
        creditCheckerResponse.setContractNo(response.getZhimaCustomerContractInitializeResponse().getContractNo());
        creditCheckerResponse.setSubCode(response.getZhimaCustomerContractInitializeResponse().getSubCode());
        creditCheckerResponse.setSubMsg(response.getZhimaCustomerContractInitializeResponse().getSubMsg());
	    return creditCheckerResponse;
	}
}
