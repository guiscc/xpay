package com.xpay.trade.common.test;

import com.xpay.trade.common.enums.EnumTradeStatus;

/**
 * Created by sxfans on 16/8/21.
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(EnumTradeStatus.toTradeStatus((byte) 1).getKey());
    }
}
