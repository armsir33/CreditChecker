package cn.credit.checker.CreditChecker.dto;

public class CreditCheckerResponse {

    // Common
    private String code;
    private String msg;
    // success
    private String contractNo;
    // failed
    private String subCode;
    private String subMsg;

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(final String contractNo) {
        this.contractNo = contractNo;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(final String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return subMsg;
    }

    public void setSubMsg(final String subMsg) {
        this.subMsg = subMsg;
    }
}
