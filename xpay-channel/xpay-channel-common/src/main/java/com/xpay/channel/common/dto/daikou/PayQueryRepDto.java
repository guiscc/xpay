package com.xpay.channel.common.dto.daikou;

import com.xpay.channel.common.dto.BaseRepDTO;

/**
 * @Remark 查询
 * @Author pangyiyang
 * @Date 16/5/22 下午4:26
 */
public class PayQueryRepDto extends BaseRepDTO {

    private String oriChannelOrderNo ;
    private Long amount ;

    public String getOriChannelOrderNo() {
        return oriChannelOrderNo;
    }

    public void setOriChannelOrderNo(String oriChannelOrderNo) {
        this.oriChannelOrderNo = oriChannelOrderNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
