package com.xpay.channel.front.tongxin.impl;

import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.tongxin.AbsChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Https单向认证
 * Created by suxinxin on 16/2/18.
 */
public class Https1ChannelHandler<REQ extends BaseReqFrontDTO> extends AbsChannelTongXinHandler<BaseReqFrontDTO> {
    @Override
    public byte[] send(BaseReqFrontDTO baseReqFrontDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        return super.send(baseReqFrontDTO, reqMsg, channelConfig);
    }
}
