package com.xpay.channel.front.vld;

import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.common.exception.VldException;

/**
 * 接口公共验证参数
 * Created by suxinxin on 15/1/15.
 */
public class BaseValidateImpl<T extends BaseReqDTO> implements ChannelValidateHandler<T> {

    @Override
    public void validate(T t) throws VldException {

    }
}
