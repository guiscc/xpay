package com.xpay.channel.front.tongxin.impl;

import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.tongxin.AbsChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Socket通信类组件
 * Created by suxinxin on 14/12/25.
 */
public class SocketChannelHandler<REQ extends BaseReqFrontDTO> extends AbsChannelTongXinHandler<BaseReqFrontDTO> {
    @Override
    public byte[] send(BaseReqFrontDTO baseReqFrontDTO, MsgReqModel msgReqModel, ChannelConfig channelConfig) throws CommuException {
        return new byte[0];
    }
}
