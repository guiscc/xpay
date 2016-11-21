package com.xpay.channel.front.channel.agentcollect.unionpay.vld;

import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.dto.agentcollect.RefundCallbackReqFrontDTO;
import com.xpay.channel.front.vld.AbsChannelValidateHandlerImpl;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午2:05
 */
public class Unionpay_RefundCallbackVld extends AbsChannelValidateHandlerImpl<RefundCallbackReqFrontDTO> {

    @Override
    public void validate(RefundCallbackReqFrontDTO param) throws VldException {
        super.validate(param);
    }
}
