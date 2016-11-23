package com.xpay.channel.front.channel.agentcollect.unionpay;

import com.xpay.channel.front.utils.ChannelConfig;

/**
 * @Remark 配置
 * @Author pangyiyang
 * @Date 16/5/21 下午1:37
 */
public class Unionpay_Config extends ChannelConfig {

    private String authUrl;
    private String payUrl;
    private String notifyUrl;
    private String payQueryUrl;
    private String encCerPath;

    /**
     * Getter method for property payQueryUrl.
     *
     * @return property value of payQueryUrl
     **/
    public String getPayQueryUrl() {
        return payQueryUrl;
    }

    /**
     * Setter method for property payQueryUrl.
     *
     * @param payQueryUrl value to be assigned to property payQueryUrl
     **/
    public void setPayQueryUrl(String payQueryUrl) {
        this.payQueryUrl = payQueryUrl;
    }

    /**
     * Getter method for property authUrl.
     *
     * @return property value of authUrl
     **/
    public String getAuthUrl() {
        return authUrl;
    }

    /**
     * Setter method for property authUrl.
     *
     * @param authUrl value to be assigned to property authUrl
     **/
    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    /**
     * Getter method for property payUrl.
     *
     * @return property value of payUrl
     **/
    public String getPayUrl() {
        return payUrl;
    }

    /**
     * Setter method for property payUrl.
     *
     * @param payUrl value to be assigned to property payUrl
     **/
    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    /**
     * Getter method for property notifyUrl.
     *
     * @return property value of notifyUrl
     **/
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * Setter method for property notifyUrl.
     *
     * @param notifyUrl value to be assigned to property notifyUrl
     **/
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    /**
     * Getter method for property encCerPath.
     *
     * @return property value of encCerPath
     **/
    public String getEncCerPath() {
        return encCerPath;
    }

    /**
     * Setter method for property encCerPath.
     *
     * @param encCerPath value to be assigned to property encCerPath
     **/
    public void setEncCerPath(String encCerPath) {
        this.encCerPath = encCerPath;
    }
}
