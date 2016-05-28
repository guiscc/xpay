package com.xpay.channel.front.channel.daikou;


import com.xpay.channel.common.dto.daikou.*;
import com.xpay.channel.common.enums.EnumTradeType;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.facade.AgentCollectChannelFacade;
import com.xpay.channel.front.msg.ChannelMsgHandler;
import com.xpay.channel.front.processer.ChannelActionProcess;
import com.xpay.channel.front.tongxin.ChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.channel.front.vld.ChannelValidateHandler;

import java.util.Map;

/**
 * 此类通过模版模式，抽象实现quickPayChannel接口，
 * 并且通过注入的方式将组件注入到类中，方便业务实现类组件核心接口调用
 */
public abstract class AbsDaifuChannel implements AgentCollectChannelFacade {

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
    public RealNameAuthRepDto auth(RealNameAuthReqDto reqDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        ChannelActionProcess<RealNameAuthReqDto, RealNameAuthRepDto> channelActionProcess = new ChannelActionProcess<RealNameAuthReqDto, RealNameAuthRepDto>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumTradeType.AUTH));
        channelActionProcess.setChannelTongXinHandler(this.getChannelTongXinHandler());
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumTradeType.AUTH));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        RealNameAuthRepDto repDto = channelActionProcess.doProcess(reqDto);
        return repDto;
    }

    @Override
    public PayRepDto pay(PayReqDto reqDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        ChannelActionProcess<PayReqDto, PayRepDto> channelActionProcess = new ChannelActionProcess<PayReqDto, PayRepDto>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumTradeType.PAY));
        channelActionProcess.setChannelTongXinHandler(this.getChannelTongXinHandler());
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumTradeType.PAY));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        PayRepDto repDto = channelActionProcess.doProcess(reqDto);
        return repDto;
    }

    @Override
    public PayQueryRepDto payQuery(PayQueryReqDto reqDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        ChannelActionProcess<PayQueryReqDto, PayQueryRepDto> channelActionProcess = new ChannelActionProcess<PayQueryReqDto, PayQueryRepDto>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumTradeType.PAYQUERY));
        channelActionProcess.setChannelTongXinHandler(this.getChannelTongXinHandler());
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumTradeType.PAYQUERY));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        PayQueryRepDto repDto = channelActionProcess.doProcess(reqDto);
        return repDto;
    }

    @Override
    public RefundRepDto refund(RefundReqDto reqDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        ChannelActionProcess<RefundReqDto, RefundRepDto> channelActionProcess = new ChannelActionProcess<RefundReqDto, RefundRepDto>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumTradeType.REFUND));
        channelActionProcess.setChannelTongXinHandler(this.getChannelTongXinHandler());
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumTradeType.REFUND));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        RefundRepDto repDto = channelActionProcess.doProcess(reqDto);
        return repDto;
    }

    @Override
    public CancelRepDto cancel(CancelReqDto reqDto) throws VldException, BuildMsgException, CommuException, ResolveMsgException {
        ChannelActionProcess<CancelReqDto, CancelRepDto> channelActionProcess = new ChannelActionProcess<CancelReqDto, CancelRepDto>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumTradeType.CANCEL));
        channelActionProcess.setChannelTongXinHandler(this.getChannelTongXinHandler());
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumTradeType.CANCEL));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        CancelRepDto repDto = channelActionProcess.doProcess(reqDto);
        return repDto;
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
