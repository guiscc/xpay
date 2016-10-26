package com.xpay.channel.front.msg;

import com.xpay.channel.front.dto.BaseRepFrontDTO;
import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * 平台报文拼解组件
 * Created by suxinxin on 14/12/25.
 */
public interface ChannelMsgHandler<REQ extends BaseReqFrontDTO, REP extends BaseRepFrontDTO> {

    /**
     * 创建报文
     * @param t
     * @param channelConfig
     * @return
     */
    public byte[] builderMsg(REQ t, ChannelConfig channelConfig) throws BuildMsgException;

    /**
     * 解析报文
     *
     * @param req
     * @param rtnMsg
     * @param channelConfig
     * @return
     */
    public REP resolveMsg(REQ req, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException;

    /**
     * 创建报文之前
     * @param req
     * @param channelConfig
     * @return
     * @throws BuildMsgException
     */
    public REQ beforBuildMsg(REQ req, ChannelConfig channelConfig) throws BuildMsgException;

    /**
     * 创建报文之后
     * @param req
     * @param reqMsg
     * @param channelConfig
     * @return
     * @throws BuildMsgException
     */
    public byte[] afterBuildMsg(REQ req, byte[] reqMsg, ChannelConfig channelConfig) throws BuildMsgException;

    /**
     * 解析报文之前
     * @param req
     * @param repMsg
     * @param channelConfig
     * @return
     * @throws ResolveMsgException
     */
    public byte[] beforResolveMsg(REQ req, byte[] repMsg, ChannelConfig channelConfig) throws ResolveMsgException;

    /**
     * 解析报文之后
     * @param req
     * @param rep
     * @param channelConfig
     * @return
     * @throws ResolveMsgException
     */
    public REP afterResolveMsg(REQ req, REP rep, ChannelConfig channelConfig) throws ResolveMsgException;
}

