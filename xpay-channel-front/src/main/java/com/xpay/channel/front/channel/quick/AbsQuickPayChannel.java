package com.xpay.channel.front.channel.quick;


import com.xpay.channel.common.dto.quick.*;
import com.xpay.channel.common.enums.EnumTradeType;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.facade.QuickPayChannelFacade;
import com.xpay.channel.front.msg.ChannelMsgHandler;
import com.xpay.channel.front.tongxin.ChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.channel.front.vld.ChannelValidateHandler;

import java.util.Map;

/**
 * 此类通过模版模式，抽象实现quickPayChannel接口，
 * 并且通过注入的方式将组件注入到类中，方便业务实现类组件核心接口调用
 */
public abstract class AbsQuickPayChannel implements QuickPayChannelFacade {

    /**
     * 参数验证组件
     */
    private Map<EnumTradeType, ChannelValidateHandler> channelValidateHandler;

    /**
     * 通信组件
     */
    private ChannelTongXinHandler channelTongXinHandler;

    /**
     * 报文组件
     */
    private Map<EnumTradeType, ChannelMsgHandler> channelMsgHandler;

    protected ThreadLocal<ChannelConfig> channelConfig = new ThreadLocal<ChannelConfig>();

    @Override
    public SignRepDTO sign(SignReqDTO signReq) throws VldException, BuildMsgException,
            CommuException, ResolveMsgException {
        return new SignRepDTO();
    }

    @Override
    public SignConfirmRepDTO signConfirm(SignConfirmReqDTO signReq) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        return new SignConfirmRepDTO()  ;
    }

    @Override
    public BreakSignRepDTO breakSign(BreakSignReqDTO breakSignReqDTO)
            throws VldException,  BuildMsgException, CommuException, ResolveMsgException {
        return new BreakSignRepDTO();
    }

    @Override
    public PayConfirmRepDTO pay(PayConfirmReqDTO payReqDTO) throws VldException, BuildMsgException,
            CommuException, ResolveMsgException {
        return new PayConfirmRepDTO();
    }

    @Override
    public PayQueryRepDTO queryPay(PayQueryReqDTO queryPayReqDTO) throws VldException, BuildMsgException,
            CommuException, ResolveMsgException {
        return new PayQueryRepDTO();
    }

    @Override
    public RefundRepDTO refund(RefundReqDTO refundReqDTO)
            throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        return new RefundRepDTO();
    }

    @Override
    public CheckFileRepDTO checkFile(CheckFileReqDTO checkFileReqDTO)
            throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        return new CheckFileRepDTO();
    }

    @Override
    public PayCallBackRepDTO callback(PayCallBackReqDTO recieveRequestDto)
            throws VldException, BuildMsgException, ResolveMsgException, CommuException {
        return new PayCallBackRepDTO();
    }


    @Override
    public RefundCallBackRepDTO refundCallback(RefundCallBackReqDTO recieveRequestDto)
            throws VldException, BuildMsgException, ResolveMsgException, CommuException {
        return new RefundCallBackRepDTO();
    }

    @Override
    public QueryCardInfoRepDTO queryCardInfo(QueryCardInfoReqDTO payReqDTO)
            throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        return new QueryCardInfoRepDTO();
    }



    public ChannelTongXinHandler getChannelTongXinHandler() {
        return channelTongXinHandler;
    }

    public void setChannelTongXinHandler(ChannelTongXinHandler channelTongXinHandler) {
        this.channelTongXinHandler = channelTongXinHandler;
    }

    public Map<EnumTradeType, ChannelMsgHandler> getChannelMsgHandler() {
        return channelMsgHandler;
    }

    public void setChannelMsgHandler(Map<EnumTradeType, ChannelMsgHandler> channelMsgHandler) {
        this.channelMsgHandler = channelMsgHandler;
    }

    public ChannelConfig getChannelConfig() {
        return channelConfig.get();
    }

    public void setChannelConfig(ChannelConfig channelConfig) {
        this.channelConfig.set(channelConfig);
    }

    public Map<EnumTradeType, ChannelValidateHandler> getChannelValidateHandler() {
        return channelValidateHandler;
    }

    public void setChannelValidateHandler(Map<EnumTradeType, ChannelValidateHandler> channelValidateHandler) {
        this.channelValidateHandler = channelValidateHandler;
    }
}
