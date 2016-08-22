package com.xpay.channel.front.channel.quick.billpay.msg;

import com.xpay.channel.common.dto.quick.RefundRepDTO;
import com.xpay.channel.common.dto.quick.RefundReqDTO;
import com.xpay.channel.front.msg.impl.FreemarkChannelMsgHandlerImpl;

/**
 * Created by suxinxin on 16/2/16.
 */
public class BillPay_RefundMsgHandler extends FreemarkChannelMsgHandlerImpl<RefundReqDTO,RefundRepDTO> {
    @Override
    protected String getTemplatePath() {
        return "/quick/billpay/refund.ftl";
    }
}
