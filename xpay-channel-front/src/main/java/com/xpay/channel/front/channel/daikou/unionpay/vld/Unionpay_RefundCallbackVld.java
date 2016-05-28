package com.xpay.channel.front.channel.daikou.unionpay.vld;

import com.xpay.channel.common.dto.daikou.RefundCallbackReqDto;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.vld.BaseValidateImpl;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午2:05
 */
public class Unionpay_RefundCallbackVld extends BaseValidateImpl<RefundCallbackReqDto> {

    @Override
    public void validate(RefundCallbackReqDto param) throws VldException {
        super.validate(param);
    }
}
