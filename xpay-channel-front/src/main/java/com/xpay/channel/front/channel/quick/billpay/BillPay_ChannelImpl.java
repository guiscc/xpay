package com.xpay.channel.front.channel.quick.billpay;

import com.xpay.channel.common.dto.quick.*;
import com.xpay.channel.common.enums.EnumTradeType;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.processer.ChannelActionProcess;
import com.xpay.channel.front.channel.quick.AbsQuickPayChannel;

/**
 * Created by suxinxin on 16/2/5.
 */
public class BillPay_ChannelImpl extends AbsQuickPayChannel {

    @Override
    public SignRepDTO sign(SignReqDTO signReq)
            throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        ChannelActionProcess<SignReqDTO, SignRepDTO> channelActionProcess = new ChannelActionProcess<SignReqDTO, SignRepDTO>();
        channelActionProcess.setChannelValidate(super.getChannelValidateHandler().get(EnumTradeType.SIGN));
        channelActionProcess.setChannelTongXinHandler(super.getChannelTongXinHandler());
        channelActionProcess.setChannelMsgHandler(super.getChannelMsgHandler().get(EnumTradeType.SIGN));
        channelActionProcess.setChannelConfig(super.getChannelConfig());
        SignRepDTO signRepDTO = channelActionProcess.doProcess(signReq);
        return signRepDTO;
    }
    
    @Override
    public SignConfirmRepDTO signConfirm(SignConfirmReqDTO signReq) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
   	 ChannelActionProcess<SignConfirmReqDTO, SignConfirmRepDTO> channelActionProcess = new ChannelActionProcess<SignConfirmReqDTO, SignConfirmRepDTO>();
        channelActionProcess.setChannelValidate(super.getChannelValidateHandler().get(EnumTradeType.SIGNCONFIRM));
        channelActionProcess.setChannelTongXinHandler(super.getChannelTongXinHandler());
        channelActionProcess.setChannelMsgHandler(super.getChannelMsgHandler().get(EnumTradeType.SIGNCONFIRM));
        channelActionProcess.setChannelConfig(super.getChannelConfig());
        return channelActionProcess.doProcess(signReq);
   } 
    
    @Override
    public BreakSignRepDTO breakSign(BreakSignReqDTO breakSignReqDTO)
            throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        return super.breakSign(breakSignReqDTO);
    }

    @Override
    public PayConfirmRepDTO pay(PayConfirmReqDTO payReqDTO)
            throws VldException, BuildMsgException, CommuException, ResolveMsgException {
    	 ChannelActionProcess<PayConfirmReqDTO, PayConfirmRepDTO> channelActionProcess = new ChannelActionProcess<PayConfirmReqDTO, PayConfirmRepDTO>();
         channelActionProcess.setChannelValidate(super.getChannelValidateHandler().get(EnumTradeType.PAY));
         channelActionProcess.setChannelTongXinHandler(super.getChannelTongXinHandler());
         channelActionProcess.setChannelMsgHandler(super.getChannelMsgHandler().get(EnumTradeType.PAY));
         channelActionProcess.setChannelConfig(super.getChannelConfig());
         return channelActionProcess.doProcess(payReqDTO);
    }

    @Override
    public PayQueryRepDTO queryPay(PayQueryReqDTO queryPayReqDTO)
            throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        ChannelActionProcess<PayQueryReqDTO,PayQueryRepDTO> channelActionProcess = new ChannelActionProcess<PayQueryReqDTO, PayQueryRepDTO>();
        channelActionProcess.setChannelValidate(super.getChannelValidateHandler().get(EnumTradeType.PAYQUERY));
        channelActionProcess.setChannelTongXinHandler(super.getChannelTongXinHandler());
        channelActionProcess.setChannelConfig(super.getChannelConfig());
        channelActionProcess.setChannelMsgHandler(super.getChannelMsgHandler().get(EnumTradeType.PAYQUERY));
        PayQueryRepDTO queryPayRepDTO = channelActionProcess.doProcess(queryPayReqDTO);
        return queryPayRepDTO;
    }

    @Override
    public RefundRepDTO refund(RefundReqDTO refundReqDTO)
            throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        return super.refund(refundReqDTO);
    }

    @Override
    public CheckFileRepDTO checkFile(CheckFileReqDTO checkFileReqDTO)
            throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        return super.checkFile(checkFileReqDTO);
    }

    @Override
    public PayCallBackRepDTO callback(PayCallBackReqDTO recieveRequestDto)
            throws VldException, BuildMsgException, ResolveMsgException, CommuException {
        return super.callback(recieveRequestDto);
    }

    @Override
    public RefundCallBackRepDTO refundCallback(RefundCallBackReqDTO recieveRequestDto)
            throws VldException, BuildMsgException, ResolveMsgException, CommuException {
        return super.refundCallback(recieveRequestDto);
    }

    @Override
    public QueryCardInfoRepDTO queryCardInfo(QueryCardInfoReqDTO payReqDTO)
            throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        return super.queryCardInfo(payReqDTO);
    }


}
