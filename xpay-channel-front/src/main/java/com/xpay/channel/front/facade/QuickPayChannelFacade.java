package com.xpay.channel.front.facade;

import com.xpay.channel.common.dto.quick.*;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;

/**
 * 前置快捷业务主要接口,上层平台通过此业务接口调用银行
 */
public interface QuickPayChannelFacade {
    /**
     * 签约
     *
     * @param signReq
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public SignRepDTO sign(SignReqDTO signReq) throws VldException, BuildMsgException, CommuException, ResolveMsgException;

    /**
     * 签约
     *
     * @param signReq
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public SignConfirmRepDTO signConfirm(SignConfirmReqDTO signReq) throws VldException, BuildMsgException, CommuException, ResolveMsgException;

    /**
     * 解约
     *
     * @param breakSignReqDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public BreakSignRepDTO breakSign(BreakSignReqDTO breakSignReqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException;

    /**
     * 支付
     *
     * @param payReqDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public PayConfirmRepDTO pay(PayConfirmReqDTO payReqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException;

    /**
     * 补单
     *
     * @param queryPayReqDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public PayQueryRepDTO queryPay(PayQueryReqDTO queryPayReqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException;

    /**
     * 退款
     *
     * @param refundReqDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RefundRepDTO refund(RefundReqDTO refundReqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException;

    /**
     * 对账
     *
     * @param checkFileReqDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public CheckFileRepDTO checkFile(CheckFileReqDTO checkFileReqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException;

    /**
     * 第三方支付系统通过回调地址通知结果
     * @param recieveRequestDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws ResolveMsgException
     * @throws CommuException
     */
    public PayCallBackRepDTO callback(PayCallBackReqDTO recieveRequestDto) throws VldException, BuildMsgException, ResolveMsgException, CommuException;

    /**
     * 第三方支付系统通过回调地址通知结果
     * @param recieveRequestDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RefundCallBackRepDTO refundCallback(RefundCallBackReqDTO recieveRequestDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException;

    /**
     * 查询卡信息
     *
     * @param payReqDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public QueryCardInfoRepDTO queryCardInfo(QueryCardInfoReqDTO payReqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException;

}
