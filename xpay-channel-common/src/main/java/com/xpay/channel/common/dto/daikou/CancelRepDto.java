package com.xpay.channel.common.dto.daikou;

import com.xpay.channel.common.dto.BaseRepDTO;

/**
 * @Remark 退货
 * @Author pangyiyang
 * @Date 16/5/23 下午8:03
 */
public class CancelRepDto extends BaseRepDTO {

    /**
     * 退款金额
     */
    private Long amount ;
    /**
     * 渠道退款单号
     */
    private String channelCancelNo ;
    /**
     * 原渠道交易单号
     */
    private String oriChannelOrderNo ;
    /**
     * 业务退款单号
     */
    private String bizCancelNo ;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getOriChannelOrderNo() {
        return oriChannelOrderNo;
    }

    public void setOriChannelOrderNo(String oriChannelOrderNo) {
        this.oriChannelOrderNo = oriChannelOrderNo;
    }

    public String getChannelCancelNo() {
        return channelCancelNo;
    }

    public void setChannelCancelNo(String channelCancelNo) {
        this.channelCancelNo = channelCancelNo;
    }

    public String getBizCancelNo() {
        return bizCancelNo;
    }

    public void setBizCancelNo(String bizCancelNo) {
        this.bizCancelNo = bizCancelNo;
    }
}
