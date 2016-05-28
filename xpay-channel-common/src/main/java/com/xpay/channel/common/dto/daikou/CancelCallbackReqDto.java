package com.xpay.channel.common.dto.daikou;

import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.common.enums.EnumNotifyType;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/28 下午3:00
 */
public class CancelCallbackReqDto extends BaseReqDTO {

    private String callbackContent ;
    private EnumNotifyType notifyType ;

    public String getCallbackContent() {
        return callbackContent;
    }

    public void setCallbackContent(String callbackContent) {
        this.callbackContent = callbackContent;
    }

    public EnumNotifyType getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(EnumNotifyType notifyType) {
        this.notifyType = notifyType;
    }

}
