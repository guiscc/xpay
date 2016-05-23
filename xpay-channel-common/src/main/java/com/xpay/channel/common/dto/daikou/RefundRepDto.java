package com.xpay.channel.common.dto.daikou;

import com.xpay.channel.common.dto.BaseRepDTO;

import java.util.Date;

/**
 * @Remark 退货
 * @Author pangyiyang
 * @Date 16/5/23 下午8:03
 */
public class RefundRepDto extends BaseRepDTO {

    /**
     * 退款金额
     */
    private Long amount ;
    /**
     * 渠道退款单号
     */
    private String channelRefundNo ;
    /**
     * 原渠道交易单号
     */
    private String oriChannelOrderNo ;
    /**
     * 业务退款单号
     */
    private String bizRefundNo ;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getChannelRefundNo() {
        return channelRefundNo;
    }

    public void setChannelRefundNo(String channelRefundNo) {
        this.channelRefundNo = channelRefundNo;
    }

    public String getOriChannelOrderNo() {
        return oriChannelOrderNo;
    }

    public void setOriChannelOrderNo(String oriChannelOrderNo) {
        this.oriChannelOrderNo = oriChannelOrderNo;
    }

    public String getBizRefundNo() {
        return bizRefundNo;
    }

    public void setBizRefundNo(String bizRefundNo) {
        this.bizRefundNo = bizRefundNo;
    }
}
