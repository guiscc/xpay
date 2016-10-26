package com.xpay.channel.front.facade;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
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
    public ACPayRepFrontFrontDTO pay(ACPayReqFrontFrontDTO reqDto);

    /**
     * 代扣结果查询
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public ACQueryPayRepFrontFrontDTO payQuery(ACQueryPayReqFrontFrontDTO reqDto);

    /**
     * 退货
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RefundRepFrontFrontDTO refund(RefundReqFrontFrontDTO reqDto);

    /**
     * 消费取消
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public CancelRepFrontFrontDTO cancel(CancelReqFrontFrontDTO reqDto);

    /**
     * 代扣回调
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public PayCallbackRepFrontFrontDTO payCallback(PayCallbackReqFrontFrontDTO reqDto);

    /**
     * 代扣退款回调
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RefundCallbackRepFrontFrontDTO refundCallback(RefundCallbackReqFrontFrontDTO reqDto);

    /**
     * 代扣交易取消回调
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public CancelCallbackRepFrontFrontDTO cancelCallback(CancelCallbackReqFrontFrontDTO reqDto);

}
