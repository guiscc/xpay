package com.xpay.channel.common.dto.daikou;

import com.xpay.channel.common.dto.BaseReqDTO;

import java.util.Date;

/**
 * @Remark 退货
 * @Author pangyiyang
 * @Date 16/5/23 下午8:03
 */
public class CancelReqDto extends BaseReqDTO {

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
    private String bizCancelNo ;
    /**
     * 渠道退款单号
     */
    private String channelCancelNo ;

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

    public String getBizCancelNo() {
        return bizCancelNo;
    }

    public void setBizCancelNo(String bizCancelNo) {
        this.bizCancelNo = bizCancelNo;
    }

    public String getChannelCancelNo() {
        return channelCancelNo;
    }

    public void setChannelCancelNo(String channelCancelNo) {
        this.channelCancelNo = channelCancelNo;
    }
}
