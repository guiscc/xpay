package com.xpay.channel.front.channel.daikou.unionpay.vld;

import com.xpay.channel.common.dto.daikou.CancelCallbackReqDto;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.vld.BaseValidateImpl;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午2:05
 */
public class Unionpay_CancelCallbackVld extends BaseValidateImpl<CancelCallbackReqDto> {

    @Override
    public void validate(CancelCallbackReqDto param) throws VldException {
        super.validate(param);
    }
}
