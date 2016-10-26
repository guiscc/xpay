package com.xpay.channel.front.channel.sms.taobao.vld;

import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.dto.sms.SmsReqFrontDTO;
import com.xpay.channel.front.vld.AbsChannelValidateHandlerImpl;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午2:05
 */
public class TaoBao_SmsVld extends AbsChannelValidateHandlerImpl<SmsReqFrontDTO> {

    @Override
    public void validate(SmsReqFrontDTO smsReqDTO) throws VldException {
        super.validate(smsReqDTO);
    }
}
