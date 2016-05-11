package com.xpay.channel.common.model;

public class ChannelRemark {
	/**
     * 商户号
     */
    private String merchantNo;

    /**
     * 回调地址
     */
    private String callbackUrl;

    /**
     * 前台回调地址
     */
    private String pageCallbackUrl;

    /**
     * 主密钥
     */
    private String zmk;

    /**
     * 会话密钥
     */
    private String zak;

    /**
     * 签名密钥
     */
    private String zpk;

    /**
     * 公钥路径
     */
    private String cerPath;

    /**
     * 私钥路径
     */
    private String pfxPath;

    /**
     * 密码
     */
    private String pwd;
    /**
     * 银行代码
     */
    private String bankCode;
    
    /**
     *  操作员账号
     */
    private String operatorCode;
    /**
     * 操作员密码
     */
    private String operatorPwd;
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	public String getPageCallbackUrl() {
		return pageCallbackUrl;
	}
	public void setPageCallbackUrl(String pageCallbackUrl) {
		this.pageCallbackUrl = pageCallbackUrl;
	}
	public String getZmk() {
		return zmk;
	}
	public void setZmk(String zmk) {
		this.zmk = zmk;
	}
	public String getZak() {
		return zak;
	}
	public void setZak(String zak) {
		this.zak = zak;
	}
	public String getZpk() {
		return zpk;
	}
	public void setZpk(String zpk) {
		this.zpk = zpk;
	}
	public String getCerPath() {
		return cerPath;
	}
	public void setCerPath(String cerPath) {
		this.cerPath = cerPath;
	}
	public String getPfxPath() {
		return pfxPath;
	}
	public void setPfxPath(String pfxPath) {
		this.pfxPath = pfxPath;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getOperatorPwd() {
		return operatorPwd;
	}
	public void setOperatorPwd(String operatorPwd) {
		this.operatorPwd = operatorPwd;
	}
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
