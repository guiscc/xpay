package com.xpay.channel.common.dto.daikou;

import com.xpay.channel.common.dto.BaseRepDTO;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/28 下午3:00
 */
public class CancelCallbackRepDto extends BaseRepDTO {

    private String responseBody ;
    private long amount ;
    private String oriChannelOrderNo ;
    private String channelCancelNo ;

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
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
}
