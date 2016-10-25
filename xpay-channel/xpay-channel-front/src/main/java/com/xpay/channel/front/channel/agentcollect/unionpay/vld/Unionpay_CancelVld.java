package com.xpay.channel.front.channel.agentcollect.unionpay.vld;

import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.dto.agentcollect.CancelReqDTO;
import com.xpay.channel.front.vld.AbsChannelValidateHandlerImpl;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午2:05
 */
public class Unionpay_CancelVld extends AbsChannelValidateHandlerImpl<CancelReqDTO> {

    @Override
    public void validate(CancelReqDTO param) throws VldException {
        super.validate(param);
    }
}
