package com.xpay.channel.front.vld;

import com.xpay.channel.front.dto.*;
import com.xpay.channel.common.exception.VldException;

/**
 * 接口公共验证参数
 * Created by suxinxin on 15/1/15.
 */
public abstract class AbsChannelValidateHandlerImpl<T extends BaseReqDTO> implements ChannelValidateHandler<T> {

    @Override
    public void validate(T t) throws VldException {

    }
}
