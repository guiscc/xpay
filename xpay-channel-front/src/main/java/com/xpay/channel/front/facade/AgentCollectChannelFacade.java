package com.xpay.channel.front.facade;

import com.xpay.channel.common.dto.daikou.*;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;

/**
 * 代扣
 * Created by suxinxin on 16/3/25.
 */
public interface AgentCollectChannelFacade {

    /**
     * 实名认证
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RealNameAuthRepDto auth(RealNameAuthReqDto reqDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException;

    /**
     * 代扣
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public PayRepDto pay(PayReqDto reqDto)throws VldException, BuildMsgException, CommuException, ResolveMsgException;

    /**
     * 代扣结果查询
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public PayQueryRepDto payQuery(PayQueryReqDto reqDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException ;


}
