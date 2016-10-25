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
public interface AgentCollectChannelFacade {

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
    public RefundRepDTO refund(RefundReqDTO reqDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException ;

    /**
     * 消费取消
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public CancelRepDTO cancel(CancelReqDTO reqDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException ;


    /**
     * 代扣回调
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public PayCallbackRepDTO payCallback(PayCallbackReqDTO reqDto)throws VldException, BuildMsgException, CommuException, ResolveMsgException ;

    /**
     * 代扣退款回调
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RefundCallbackRepDTO refundCallback(RefundCallbackReqDTO reqDto)throws VldException, BuildMsgException, CommuException, ResolveMsgException ;

    /**
     * 代扣交易取消回调
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public CancelCallbackRepDTO cancelCallback(CancelCallbackReqDTO reqDto)throws VldException, BuildMsgException, CommuException, ResolveMsgException ;


}
