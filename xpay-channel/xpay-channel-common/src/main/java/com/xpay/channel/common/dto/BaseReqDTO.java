package com.xpay.channel.common.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by suxinxin on 16/2/5.
 */
public class BaseReqDTO {
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
