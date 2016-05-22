package com.xpay.channel.common.dto.daikou;

import com.xpay.channel.common.dto.BaseReqDTO;

import java.util.Date;

/**
 * @Remark 查询
 * @Author pangyiyang
 * @Date 16/5/22 下午4:26
 */
public class PayQueryReqDto extends BaseReqDTO {

    private String oriChannelOrderNo ;
    private String oriBizOrderNo ;
    private Date channelCreateDate ;

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
}
