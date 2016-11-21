package com.xpay.channel.front.facade;

import com.xpay.channel.common.dto.customer.SignRepChannelDTO;
import com.xpay.channel.common.dto.customer.SignReqChannelDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.dto.quickpay.*;

/**
 * 前置快捷业务主要接口,上层平台通过此业务接口调用银行
 */
public interface QuickPayFrontFacade {

    /**
     * 签约
     * @param signReq
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public SignRepChannelDTO sign(SignReqChannelDTO signReq);

    /**
     * 支付
     *
     * @param payReqDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public PayConfirmRepFrontDTO pay(PayConfirmReqFrontDTO payReqDTO);

    /**
     * 补单
     *
     * @param queryPayReqDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public PayQueryRepFrontDTO queryPay(PayQueryReqFrontDTO queryPayReqDTO) ;

    /**
     * 退款
     *
     * @param refundReqDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RefundRepFrontDTO refund(RefundReqFrontDTO refundReqDTO);

    /**
     * 对账
     *
     * @param checkFileReqFrontDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public CheckFileRepFrontDTO checkFile(CheckFileReqFrontDTO checkFileReqFrontDTO);

    /**
     * 第三方支付系统通过回调地址通知结果
     * @param recieveRequestDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws ResolveMsgException
     * @throws CommuException
     */
    public PayCallBackRepFrontDTO callback(PayCallBackReqFrontDTO recieveRequestDto);

    /**
     * 第三方支付系统通过回调地址通知结果
     * @param recieveRequestDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RefundCallBackRepFrontDTO refundCallback(RefundCallBackReqFrontDTO recieveRequestDto);

    /**
     * 查询卡信息
     *
     * @param payReqDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public QueryCardInfoRepFrontDTO queryCardInfo(QueryCardInfoReqFrontDTO payReqDTO);

}
