package com.xpay.channel.front.channel.agentcollect.unionpay.vld;

import com.xpay.channel.front.dto.agentcollect.ACPayReqDTO;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.vld.AbsChannelValidateHandlerImpl;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午2:05
 */
public class Unionpay_PayVld extends AbsChannelValidateHandlerImpl<ACPayReqDTO> {

    @Override
    public void validate(ACPayReqDTO param) throws VldException {
        super.validate(param);
    }

}
