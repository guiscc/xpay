package com.xpay.channel.common.dto.daikou;

import com.xpay.channel.common.dto.BaseReqDTO;

import java.util.Date;

/**
 * @Remark 退货
 * @Author pangyiyang
 * @Date 16/5/23 下午8:03
 */
public class RefundReqDto extends BaseReqDTO {

    /**
     * 原渠道交易单号
     */
    private String oriChannelOrderNo ;
    /**
     * 原业务交易单号
     */
    private String oriBizOrderNo ;
    /**
     * 原银行交易单号
     */
    private String oriBankNo ;
    /**
     * 原交易金额
     */
    private Long oriAmount ;
    /**
     * 退款金额
     */
    private Long amount ;
    /**
     * 交易创建时间
     */
    private Date channelCreateDate ;
    /**
     * 业务退款单号
     */
    private String bizRefundNo ;
    /**
     * 渠道退款单号
     */
    private String channelRefundNo ;

    public String getOriChannelOrderNo() {
        return oriChannelOrderNo;
    }

    public void setOriChannelOrderNo(String oriChannelOrderNo) {
        this.oriChannelOrderNo = oriChannelOrderNo;
    }

    public String getOriBizOrderNo() {
        return oriBizOrderNo;
    }

    public void setOriBizOrderNo(String oriBizOrderNo) {
        this.oriBizOrderNo = oriBizOrderNo;
    }

    public Date getChannelCreateDate() {
        return channelCreateDate;
    }

    public void setChannelCreateDate(Date channelCreateDate) {
        this.channelCreateDate = channelCreateDate;
    }

    public String getBizRefundNo() {
        return bizRefundNo;
    }

    public void setBizRefundNo(String bizRefundNo) {
        this.bizRefundNo = bizRefundNo;
    }

    public String getOriBankNo() {
        return oriBankNo;
    }

    public void setOriBankNo(String oriBankNo) {
        this.oriBankNo = oriBankNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getOriAmount() {
        return oriAmount;
    }

    public void setOriAmount(Long oriAmount) {
        this.oriAmount = oriAmount;
    }

    public String getChannelRefundNo() {
        return channelRefundNo;
    }

    public void setChannelRefundNo(String channelRefundNo) {
        this.channelRefundNo = channelRefundNo;
    }
}
