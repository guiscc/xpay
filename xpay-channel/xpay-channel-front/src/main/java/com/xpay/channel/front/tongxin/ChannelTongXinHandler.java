package com.xpay.channel.front.tongxin;

import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * 平台通信组件抽象接口
 * Created by suxinxin on 14/12/25.
 */
public interface ChannelTongXinHandler<REQ extends BaseReqFrontDTO> {

    /**
     * 报文发送配置
     * @param req
     * @param reqMsg
     * @param channelConfig
     * @return
     * @throws CommuException
     */
    public byte[] send(REQ req, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException;

    /**
     * 发送之前
     * @param req
     * @param reqMsg
     * @param channelConfig
     * @return
     * @throws CommuException
     */
    public byte[] sendBefor(REQ req, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException;

    /**
     * 发送之后
     * @param req
     * @param reqMsg
     * @param channelConfig
     * @return
     * @throws CommuException
     */
    public byte[] sendAfter(REQ req, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException;
}
