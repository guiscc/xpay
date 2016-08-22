package com.xpay.trade.common.enums;

/**
 * Created by sxfans on 16/8/21.
 */
public enum EnumTradeSubType {
    RECHARGE((byte) 1, "充值"),
    WITHDRAWAL((byte) 2, "提现"),
    TRANSFER((byte) 3, "转账"),
    DANBAO((byte) 4, "担保收单交易"),
    GENERALACCEPT((byte) 5, "普通收单交易"),
    DANBAOCANCEL((byte) 6, "担保收单撤销退款(未收货)"),
    REFUND((byte) 7, "担保收单退款(已收货)"),
    GENERALREFUND((byte) 8, "普通收单退款"),
    NOTFULLPAYREFUND((byte) 9, "未足额支付退款"),
    PAYMENT((byte) 10, "代付交易"),
    MERSETTLEMENT((byte) 11, "商户结算款"),
    CASHREFUND((byte) 12, "提现退票"),
    PAYMENTREFUND((byte) 13, "代付退票"),
    TICKETREFUND((byte) 14, "退款退票"),
    KARECHARGE((byte) 15, "KA充值"),
    HIGORECHARGE((byte) 16, "HIGO充值"),
    MERCHANTRECHARGE((byte) 17, "商家充值"),
    REPEATPAYREFUND((byte) 18, "重复支付退款"),
    PERSONALRECHARGEREFUND((byte) 19, "个人会员充值退款"),
    MODIFYFREIGHTREFUND((byte) 20, "修改运费退款"),
    RAPIDDANBAOCANCEL((byte) 21, "极速担保撤销");

    private final byte key;
    private final String val;

    EnumTradeSubType(byte key, String val) {
        this.key = key;
        this.val = val;
    }

    public static EnumTradeSubType toTradeSubType(byte key){
        for (EnumTradeSubType type : EnumTradeSubType.values()){
            if (type.key == key){
                return type;
            }
        }
        return null;
    }

    public byte getKey() {
        return key;
    }

    public String getVal() {
        return val;
    }
}
