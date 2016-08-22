package com.xpay.trade.common.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 查询结果返回
 * Created by sxfans on 16/8/12.
 */
public class QueryTradeRepDTO extends BaseRepDTO {


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
