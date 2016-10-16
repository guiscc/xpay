package com.xpay.channel.front.facade;

import com.xpay.channel.common.dto.agentcollect.*;
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
    public ACPayRepDTO pay(ACPayReqDTO reqDto)throws VldException, BuildMsgException, CommuException, ResolveMsgException;

    /**
     * 代扣结果查询
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public ACQueryPayRepDTO payQuery(ACQueryPayReqDTO reqDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException ;

    /**
     * 退货
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RefundRepDto refund(RefundReqDto reqDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException ;

    /**
     * 消费取消
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public CancelRepDto cancel(CancelReqDto reqDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException ;


    /**
     * 代扣回调
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public PayCallbackRepDto payCallback(PayCallbackReqDto reqDto)throws VldException, BuildMsgException, CommuException, ResolveMsgException ;

    /**
     * 代扣退款回调
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RefundCallbackRepDto refundCallback(RefundCallbackReqDto reqDto)throws VldException, BuildMsgException, CommuException, ResolveMsgException ;

    /**
     * 代扣交易取消回调
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public CancelCallbackRepDto cancelCallback(CancelCallbackReqDto reqDto)throws VldException, BuildMsgException, CommuException, ResolveMsgException ;


}
