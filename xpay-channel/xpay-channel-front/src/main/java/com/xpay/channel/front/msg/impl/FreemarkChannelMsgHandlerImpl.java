package com.xpay.channel.front.msg.impl;

import java.util.HashMap;
import java.util.Map;

import com.xpay.channel.front.dto.BaseRepFrontDTO;
import com.xpay.channel.front.msg.ChannelMsgHandler;
import com.xpay.common.enums.EnumRtnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.channel.front.utils.FreeMarkerUtil;

/**
 * freemarker拼装报文，平台主要以这种方式拼装
 * Created by suxinxin on 14/12/25.
 */
public abstract class FreemarkChannelMsgHandlerImpl<REQ extends BaseReqFrontDTO, REP extends BaseRepFrontDTO>
        implements ChannelMsgHandler<REQ, REP> {
    private static final Logger logger = LoggerFactory.getLogger(FreemarkChannelMsgHandlerImpl.class);

    @Override
    public REQ beforBuildMsg(REQ req, ChannelConfig channelConfig) throws BuildMsgException {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        this.map.set(paramMap);
        return req;
    }

    @Override
    public byte[] builderMsg(REQ t, ChannelConfig channelConfig) throws BuildMsgException {
        String templateStr = null;
        this.put("req", t);
        this.put("cfg",channelConfig);
        try {
            templateStr = FreeMarkerUtil.getInstance().getStrByTemplate(this.map.get(), getTemplatePath());
        } catch (Exception e) {
            logger.error("fmk拼装报文异常",e);
            throw new BuildMsgException(EnumRtnResult.E030201);
        }
        return templateStr.getBytes();
    }

    @Override
    public byte[] afterBuildMsg(REQ req, byte[] reqMsg, ChannelConfig channelConfig) throws BuildMsgException {
        return reqMsg;
    }

    @Override
    public byte[] beforResolveMsg(REQ req, byte[] repMsg, ChannelConfig channelConfig) throws ResolveMsgException {
        return repMsg;
    }


    @Override
    public REP resolveMsg(REQ req, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
        return null;
    }

    @Override
    public REP afterResolveMsg(REQ req, REP rep, ChannelConfig channelConfig) throws ResolveMsgException {
        return rep;
    }

    /**
     * 获得模版路经
     *
     * @return
     */
    protected abstract String getTemplatePath();

    protected ThreadLocal<Map<String, Object>> map = new ThreadLocal<Map<String, Object>>();

    protected void put(String key, Object value) {
        if (value == null) {
            value = "";
        }
        Map<String, Object> dataMap = map.get();
        dataMap.put(key, value);
    }

    protected Object get(String key) {
        if (key == null) {
            return null;
        }
        return map.get().get(key);
    }

}
