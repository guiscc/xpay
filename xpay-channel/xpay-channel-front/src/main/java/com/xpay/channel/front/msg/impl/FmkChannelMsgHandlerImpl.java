package com.xpay.channel.front.msg.impl;

import com.xpay.channel.common.enums.EnumMsgReqType;
import com.xpay.channel.front.dto.BaseRepFrontDTO;
import com.xpay.channel.front.msg.AbsChannelMsgHandler;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.common.enums.EnumRtnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.channel.front.utils.FreeMarkerUtil;

/**
 * freemarker拼装报文，平台主要以这种方式拼装
 * Created by suxinxin on 14/12/25.
 */
public abstract class FmkChannelMsgHandlerImpl<REQ extends BaseReqFrontDTO, REP extends BaseRepFrontDTO>
                                                                                                         extends
                                                                                                         AbsChannelMsgHandler<REQ, REP> {
    private static final Logger logger = LoggerFactory.getLogger(FmkChannelMsgHandlerImpl.class);

    @Override
    public REQ beforBuildMsg(REQ req, ChannelConfig channelConfig) throws BuildMsgException {
        return req;
    }

    @Override
    public MsgReqModel builderMsg(REQ req, ChannelConfig channelConfig) throws BuildMsgException {
        String templateStr = null;
        req.getFmkMap().put("req", req);
        req.getFmkMap().put("cfg", channelConfig);
        try {
            templateStr = FreeMarkerUtil.getInstance().getStrByTemplate(req.getFmkMap(),
                getTemplatePath());
        } catch (Exception e) {
            logger.error("fmk拼装报文异常", e);
            throw new BuildMsgException(EnumRtnResult.E030201);
        }
        MsgReqModel msgReqModel = new MsgReqModel();
        msgReqModel.setMsgType(EnumMsgReqType.STR);
        msgReqModel.setMsgStr(templateStr);
        return msgReqModel;
    }

    /**
     * 获得模版路经
     *
     * @return
     */
    protected abstract String getTemplatePath();
}
