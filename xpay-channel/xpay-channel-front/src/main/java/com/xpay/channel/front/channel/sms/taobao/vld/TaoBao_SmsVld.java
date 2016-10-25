package com.xpay.channel.front.channel.sms.taobao.vld;

import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthReqDTO;
import com.xpay.channel.front.dto.sms.SmsReq;
import com.xpay.channel.front.vld.AbsChannelValidateHandlerImpl;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午2:05
 */
public class TaoBao_SmsVld extends AbsChannelValidateHandlerImpl<SmsReq> {

    @Override
    public void validate(SmsReq smsReq) throws VldException {
        super.validate(smsReq);
    }
}
