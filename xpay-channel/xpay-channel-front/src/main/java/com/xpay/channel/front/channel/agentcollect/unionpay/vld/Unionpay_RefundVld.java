package com.xpay.channel.front.channel.agentcollect.unionpay.vld;

import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.dto.agentcollect.RefundReqFrontDTO;
import com.xpay.channel.front.vld.AbsChannelValidateHandlerImpl;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午2:05
 */
public class Unionpay_RefundVld extends AbsChannelValidateHandlerImpl<RefundReqFrontDTO> {

    @Override
    public void validate(RefundReqFrontDTO param) throws VldException {
        super.validate(param);
    }
}
