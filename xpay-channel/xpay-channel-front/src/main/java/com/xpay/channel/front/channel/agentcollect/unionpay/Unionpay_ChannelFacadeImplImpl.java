package com.xpay.channel.front.channel.agentcollect.unionpay;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.channel.agentcollect.AgentCollectChannelFacadeImpl;
import com.xpay.channel.front.dto.agentcollect.*;
import com.xpay.channel.front.executor.AbsChannelExecutorImpl;
import com.xpay.common.enums.EnumChannelType;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午1:38
 */
public class Unionpay_ChannelFacadeImplImpl extends AgentCollectChannelFacadeImpl {

    @Override
    public ACPayRepDTO pay(ACPayReqDTO reqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        AbsChannelExecutorImpl<ACPayReqDTO, ACPayRepDTO> channelActionProcess = new AbsChannelExecutorImpl<ACPayReqDTO, ACPayRepDTO>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumChannelType.PAY));
        channelActionProcess.setChannelTongXinHandler(this.getChannelTongXinHandler());
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumChannelType.PAY));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        ACPayRepDTO repDTO = channelActionProcess.doProcess(reqDTO);
        return repDTO;
    }

    @Override
    public ACQueryPayRepDTO payQuery(ACQueryPayReqDTO reqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        AbsChannelExecutorImpl<ACQueryPayReqDTO, ACQueryPayRepDTO> channelActionProcess = new AbsChannelExecutorImpl<ACQueryPayReqDTO, ACQueryPayRepDTO>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumChannelType.PAYQUERY));
        channelActionProcess.setChannelTongXinHandler(this.getChannelTongXinHandler());
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumChannelType.PAYQUERY));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        ACQueryPayRepDTO repDTO = channelActionProcess.doProcess(reqDTO);
        return repDTO;
    }

    @Override
    public RefundRepDTO refund(RefundReqDTO reqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        AbsChannelExecutorImpl<RefundReqDTO, RefundRepDTO> channelActionProcess = new AbsChannelExecutorImpl<RefundReqDTO, RefundRepDTO>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumChannelType.REFUND));
        channelActionProcess.setChannelTongXinHandler(this.getChannelTongXinHandler());
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumChannelType.REFUND));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        RefundRepDTO repDTO = channelActionProcess.doProcess(reqDTO);
        return repDTO;
    }

    @Override
    public CancelRepDTO cancel(CancelReqDTO reqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        AbsChannelExecutorImpl<CancelReqDTO, CancelRepDTO> channelActionProcess = new AbsChannelExecutorImpl<CancelReqDTO, CancelRepDTO>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumChannelType.CANCEL));
        channelActionProcess.setChannelTongXinHandler(this.getChannelTongXinHandler());
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumChannelType.CANCEL));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        CancelRepDTO repDTO = channelActionProcess.doProcess(reqDTO);
        return repDTO;
    }

    @Override
    public PayCallbackRepDTO payCallback(PayCallbackReqDTO reqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        AbsChannelExecutorImpl<PayCallbackReqDTO, PayCallbackRepDTO> channelActionProcess = new AbsChannelExecutorImpl<PayCallbackReqDTO, PayCallbackRepDTO>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumChannelType.PAYCALLBACK));
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumChannelType.PAYCALLBACK));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        PayCallbackRepDTO repDTO = channelActionProcess.doProcess(reqDTO);
        return repDTO;
    }

    @Override
    public RefundCallbackRepDTO refundCallback(RefundCallbackReqDTO reqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        AbsChannelExecutorImpl<RefundCallbackReqDTO, RefundCallbackRepDTO> channelActionProcess = new AbsChannelExecutorImpl<RefundCallbackReqDTO, RefundCallbackRepDTO>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumChannelType.REFUNDCALLBACK));
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumChannelType.REFUNDCALLBACK));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        RefundCallbackRepDTO repDTO = channelActionProcess.doProcess(reqDTO);
        return repDTO;
    }

    @Override
    public CancelCallbackRepDTO cancelCallback(CancelCallbackReqDTO reqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        AbsChannelExecutorImpl<CancelCallbackReqDTO, CancelCallbackRepDTO> channelActionProcess = new AbsChannelExecutorImpl<CancelCallbackReqDTO, CancelCallbackRepDTO>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumChannelType.CANCELCALLBACK));
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumChannelType.CANCELCALLBACK));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        CancelCallbackRepDTO repDTO = channelActionProcess.doProcess(reqDTO);
        return repDTO;
    }


//    @Override
//    public RealNameAuthRepDTO auth(RealNameAuthReqDTO reqDTO) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
//        AbsChannelExecutorImpl<RealNameAuthReqDTO, RealNameAuthRepDTO> channelActionProcess = new AbsChannelExecutorImpl<RealNameAuthReqDTO, RealNameAuthRepDTO>();
//        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumTradeType.AUTH));
//        channelActionProcess.setChannelTongXinHandler(this.getChannelTongXinHandler());
//        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumTradeType.AUTH));
//        channelActionProcess.setChannelConfig(this.getChannelConfig());
//        RealNameAuthRepDTO repDTO = channelActionProcess.doProcess(reqDTO);
//        return repDTO;
//    }
}
