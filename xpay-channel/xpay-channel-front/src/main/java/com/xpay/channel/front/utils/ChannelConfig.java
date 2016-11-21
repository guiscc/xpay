package com.xpay.channel.front.utils;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 前置平台配置文件公共参数类
 * Created by suxinxin on 14/12/25.
 */
public class ChannelConfig {
    /**
     * 银行url
     */
    private String bankURL;

    /**
     * 密钥路径
     */
    private String pfxPath;

    /**
     * 密钥库密码
     */
    private String pfxPwd;

    /**
     * 公钥路径
     */
    private String cerPath;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 连接超时
     */
    private String connTimeOut;

    /**
     * 读超时
     */
    private String readTimeOut;

    /**
     * 报文编码
     */
    private String charset;

    public String getBankURL() {
        return bankURL;
    }

    public void setBankURL(String bankURL) {
        this.bankURL = bankURL;
    }

    public String getPfxPath() {
        return pfxPath;
    }

    public void setPfxPath(String pfxPath) {
        this.pfxPath = pfxPath;
    }

    public String getConnTimeOut() {
        return connTimeOut;
    }

    public void setConnTimeOut(String connTimeOut) {
        this.connTimeOut = connTimeOut;
    }

    public String getReadTimeOut() {
        return readTimeOut;
    }

    public void setReadTimeOut(String readTimeOut) {
        this.readTimeOut = readTimeOut;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * Getter method for property pfxPwd.
     *
     * @return property value of pfxPwd
     **/
    public String getPfxPwd() {
        return pfxPwd;
    }

    /**
     * Setter method for property pfxPwd.
     *
     * @param pfxPwd value to be assigned to property pfxPwd
     **/
    public void setPfxPwd(String pfxPwd) {
        this.pfxPwd = pfxPwd;
    }

    /**
     * Getter method for property merchantNo.
     *
     * @return property value of merchantNo
     **/
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * Setter method for property merchantNo.
     *
     * @param merchantNo value to be assigned to property merchantNo
     **/
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    /**
     * Getter method for property cerPath.
     *
     * @return property value of cerPath
     **/
    public String getCerPath() {
        return cerPath;
    }

    /**
     * Setter method for property cerPath.
     *
     * @param cerPath value to be assigned to property cerPath
     **/
    public void setCerPath(String cerPath) {
        this.cerPath = cerPath;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
