package cn.credit.checker.CreditChecker.model;

public class AliContractInitializeResponse {
    private String code;
    private String msg;
    private String sub_code;
    private String sub_msg;
    private String sign;
    private String contractNo;

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

    public String getSubCode() {
        return sub_code;
    }

    public void setSubCode(final String sub_code) {
        this.sub_code = sub_code;
    }

    public String getSubMsg() {
        return sub_msg;
    }

    public void setSubMsg(final String sub_msg) {
        this.sub_msg = sub_msg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(final String sign) {
        this.sign = sign;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(final String contractNo) {
        this.contractNo = contractNo;
    }
}
