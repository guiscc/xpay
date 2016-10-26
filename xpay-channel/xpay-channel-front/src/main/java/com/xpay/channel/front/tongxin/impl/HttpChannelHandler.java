package com.xpay.channel.front.tongxin.impl;

import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.front.tongxin.AbsChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http通信类组件
 * Created by suxinxin on 14/12/25.
 */
public class HttpChannelHandler<REQ extends BaseReqFrontDTO> extends AbsChannelTongXinHandler<BaseReqFrontDTO> {

    private static final Logger logger = LoggerFactory.getLogger(HttpChannelHandler.class);

    @Override
    public byte[] send(BaseReqFrontDTO baseReqFrontDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        return super.send(baseReqFrontDTO, reqMsg, channelConfig);
    }

    @Override
    public byte[] sendBefor(BaseReqFrontDTO baseReqFrontDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        return super.sendBefor(baseReqFrontDTO, reqMsg, channelConfig);
    }

    @Override
    public byte[] sendAfter(BaseReqFrontDTO baseReqFrontDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        return super.sendAfter(baseReqFrontDTO, reqMsg, channelConfig);
    }
}
