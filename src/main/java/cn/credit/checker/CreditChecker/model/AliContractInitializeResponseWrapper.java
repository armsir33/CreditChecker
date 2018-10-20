package cn.credit.checker.CreditChecker.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AliContractInitializeResponseWrapper {
    private AliContractInitializeResponse zhima_customer_contract_initialize_response;

    public AliContractInitializeResponse getZhimaCustomerContractInitializeResponse() {
        return zhima_customer_contract_initialize_response;
    }

    public void setZhimaCustomerContractInitializeResponse(final AliContractInitializeResponse zhima_customer_contract_initialize_response) {
        this.zhima_customer_contract_initialize_response = zhima_customer_contract_initialize_response;
    }
}
