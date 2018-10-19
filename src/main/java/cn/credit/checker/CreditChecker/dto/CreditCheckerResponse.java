package cn.credit.checker.CreditChecker.dto;

public class CreditCheckerResponse {

    private String appId;
    private String productCode;
    private String contractName;
    private String contractFile;

    public String getAppId() {
        return appId;
    }

    public void setAppId(final String appId) {
        this.appId = appId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(final String productCode) {
        this.productCode = productCode;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(final String contractName) {
        this.contractName = contractName;
    }

    public String getContractFile() {
        return contractFile;
    }

    public void setContractFile(final String contractFile) {
        this.contractFile = contractFile;
    }
}
