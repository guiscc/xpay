package com.xpay.channel.common.dto.daikou;

import com.xpay.channel.common.dto.BaseRepDTO;

/**
 * @Remark 扣款返回
 * @Author pangyiyang
 * @Date 16/5/21 下午3:34
 */
public class PayRepDto extends BaseRepDTO {

    private String channelOrderno ;
    private Long amount ;

    public String getChannelOrderno() {
        return channelOrderno;
    }

    public void setChannelOrderno(String channelOrderno) {
        this.channelOrderno = channelOrderno;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
