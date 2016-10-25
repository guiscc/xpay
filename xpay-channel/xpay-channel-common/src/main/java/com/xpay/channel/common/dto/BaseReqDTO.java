package com.xpay.channel.common.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by suxinxin on 16/2/5.
 */
public class BaseReqDTO {

    /**
     * 银行地址
     */
    private String bankUrl = "";

    /**
     * Getter method for property bankUrl.
     *
     * @return property value of bankUrl
     **/
    public String getBankUrl() {
        return bankUrl;
    }

    /**
     * Setter method for property bankUrl.
     *
     * @param bankUrl value to be assigned to property bankUrl
     **/
    public void setBankUrl(String bankUrl) {
        this.bankUrl = bankUrl;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
