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
    private String pxfPath;

    /**
     * 密码
     */
    private String pxfPass;

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

    public String getPxfPath() {
        return pxfPath;
    }

    public void setPxfPath(String pxfPath) {
        this.pxfPath = pxfPath;
    }

    public String getConnTimeOut() {
        return connTimeOut;
    }

    public void setConnTimeOut(String connTimeOut) {
        this.connTimeOut = connTimeOut;
    }

    public String getPxfPass() {
        return pxfPass;
    }

    public void setPxfPass(String pxfPass) {
        this.pxfPass = pxfPass;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this) ;
    }
}
