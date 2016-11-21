package com.xpay.channel.front.facade;

import com.xpay.channel.common.exception.*;
import com.xpay.channel.front.dto.agentcollect.*;

/**
 * 代扣
 * Created by suxinxin on 16/3/25.
 */
public interface AgentCollectFrontFacade {

    /**
     * 代扣
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public ACPayRepFrontDTO pay(ACPayReqFrontDTO reqDto) throws FrontException;

    /**
     * 代扣结果查询
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public ACQueryPayRepFrontDTO payQuery(ACQueryPayReqFrontDTO reqDto) throws FrontException;

    /**
     * 退货
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RefundRepFrontDTO refund(RefundReqFrontDTO reqDto);

    /**
     * 消费取消
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public CancelRepFrontDTO cancel(CancelReqFrontDTO reqDto);

    /**
     * 代扣回调
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public PayCallbackRepFrontDTO payCallback(PayCallbackReqFrontDTO reqDto);

    /**
     * 代扣退款回调
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RefundCallbackRepFrontDTO refundCallback(RefundCallbackReqFrontDTO reqDto);

    /**
     * 代扣交易取消回调
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public CancelCallbackRepFrontDTO cancelCallback(CancelCallbackReqFrontDTO reqDto);

}
