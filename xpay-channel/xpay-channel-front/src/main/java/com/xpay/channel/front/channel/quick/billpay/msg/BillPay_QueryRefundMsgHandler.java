package com.xpay.channel.front.channel.quick.billpay.msg;

import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.msg.impl.FreemarkChannelMsgHandlerImpl;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Created by suxinxin on 16/2/16.
 */
public class BillPay_QueryRefundMsgHandler extends FreemarkChannelMsgHandlerImpl<PayQueryReqDTO,PayQueryRepDTO> {
    @Override
    protected String getTemplatePath() {
        return "/quick/billpay/queryRefund.ftl";
    }

    @Override
    public PayQueryRepDTO resolveMsg(PayQueryReqDTO queryPayReqDTO, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
        return super.resolveMsg(queryPayReqDTO, rtnMsg, channelConfig);
    }
}
