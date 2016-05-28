package com.xpay.channel.front.channel.daikou.unionpay;

import com.xpay.channel.front.utils.ChannelConfig;

/**
 * @Remark 配置
 * @Author pangyiyang
 * @Date 16/5/21 下午1:37
 */
public class Unionpay_Config extends ChannelConfig {
    //实名
    private String authUrl ;        //认证地址
    private String version ;        //版本号5.0.0
    private String certId ;         //私钥证书的serialNumber
    private String encryptCertId ;  //公钥证书的serialNumber
    private String signMethod ;     //签名方法RSA
    private String txnType ;        //交易类型72
    private String txnSubType ;     //交易子类01
    private String bizType ;        //产品类型000401
    private String channelType ;    //渠道类型07
    private String accessType ;     //接入类型0
    private String accType ;        //账号类型01

    //代扣
    private String daikouTxnType ;
    private String daikouTxnSubType ;
    private String daikouBizType ;
    private String daikouCurrencyCode ;
    private String certifTp ;
    private String notifyUrl ;
    private String daikouUrl ;
    private String encCerPath ;

    //查询
    private String queryUrl ;
    private String queryTxnType ;

    //退货
    private String refundTxnType ;

    //实名
    private String authSubTxnType ;


    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public String getEncryptCertId() {
        return encryptCertId;
    }

    public void setEncryptCertId(String encryptCertId) {
        this.encryptCertId = encryptCertId;
    }

    public String getSignMethod() {
        return signMethod;
    }

    public void setSignMethod(String signMethod) {
        this.signMethod = signMethod;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getTxnSubType() {
        return txnSubType;
    }

    public void setTxnSubType(String txnSubType) {
        this.txnSubType = txnSubType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getDaikouTxnType() {
        return daikouTxnType;
    }

    public void setDaikouTxnType(String daikouTxnType) {
        this.daikouTxnType = daikouTxnType;
    }

    public String getDaikouTxnSubType() {
        return daikouTxnSubType;
    }

    public void setDaikouTxnSubType(String daikouTxnSubType) {
        this.daikouTxnSubType = daikouTxnSubType;
    }

    public String getDaikouBizType() {
        return daikouBizType;
    }

    public void setDaikouBizType(String daikouBizType) {
        this.daikouBizType = daikouBizType;
    }

    public String getDaikouCurrencyCode() {
        return daikouCurrencyCode;
    }

    public void setDaikouCurrencyCode(String daikouCurrencyCode) {
        this.daikouCurrencyCode = daikouCurrencyCode;
    }

    public String getCertifTp() {
        return certifTp;
    }

    public void setCertifTp(String certifTp) {
        this.certifTp = certifTp;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getDaikouUrl() {
        return daikouUrl;
    }

    public void setDaikouUrl(String daikouUrl) {
        this.daikouUrl = daikouUrl;
    }

    public String getEncCerPath() {
        return encCerPath;
    }

    public void setEncCerPath(String encCerPath) {
        this.encCerPath = encCerPath;
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    public String getQueryTxnType() {
        return queryTxnType;
    }

    public void setQueryTxnType(String queryTxnType) {
        this.queryTxnType = queryTxnType;
    }

    public String getRefundTxnType() {
        return refundTxnType;
    }

    public void setRefundTxnType(String refundTxnType) {
        this.refundTxnType = refundTxnType;
    }

    public String getAuthSubTxnType() {
        return authSubTxnType;
    }

    public void setAuthSubTxnType(String authSubTxnType) {
        this.authSubTxnType = authSubTxnType;
    }
}
