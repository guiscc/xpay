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
    public PayConfirmRepFrontFrontDTO pay(PayConfirmReqFrontFrontDTO payReqDTO);

    /**
     * 补单
     *
     * @param queryPayReqDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public PayQueryRepFrontFrontDTO queryPay(PayQueryReqFrontFrontDTO queryPayReqDTO) ;

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
    public CheckFileRepFrontFrontDTO checkFile(CheckFileReqFrontFrontDTO checkFileReqFrontDTO);

    /**
     * 第三方支付系统通过回调地址通知结果
     * @param recieveRequestDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws ResolveMsgException
     * @throws CommuException
     */
    public PayCallBackRepFrontFrontDTO callback(PayCallBackReqFrontFrontDTO recieveRequestDto);

    /**
     * 第三方支付系统通过回调地址通知结果
     * @param recieveRequestDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RefundCallBackRepFrontFrontDTO refundCallback(RefundCallBackReqFrontFrontDTO recieveRequestDto);

    /**
     * 查询卡信息
     *
     * @param payReqDTO
     * @return
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public QueryCardInfoRepFrontFrontDTO queryCardInfo(QueryCardInfoReqFrontFrontDTO payReqDTO);

}
