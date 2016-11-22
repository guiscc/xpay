package com.xpay.channel.front.tongxin.impl;

import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.msg.model.MsgRepModel;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.common.enums.EnumRtnResult;
import com.xpay.common.utils.HttpCfg;
import com.xpay.common.utils.HttpRep;
import com.xpay.common.utils.HttpReq;
import com.xpay.common.utils.HttpRequester;
import com.xpay.channel.front.tongxin.AbsChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * https双向认证
 * Created by suxinxin on 16/2/18.
 */
public class Https1ChannelHandler<REQ extends BaseReqFrontDTO> extends AbsChannelTongXinHandler<BaseReqFrontDTO> {
    private static final Logger logger = LoggerFactory.getLogger(Https2ChannelHandler.class);

    @Override
    public MsgRepModel send(BaseReqFrontDTO baseReqFrontDTO, MsgReqModel reqMsg, ChannelConfig channelConfig)
            throws CommuException {
        try {
            HttpReq httpReq = new HttpReq(); //创建http请求数据
            httpReq.setRequestBody(new String(reqMsg.getMsgBytes(), channelConfig.getCharset()));
            httpReq.setHeadMap(baseReqFrontDTO.getHttpHeadMap());

            HttpCfg httpCfg = new HttpCfg();
            httpCfg.setCharset(channelConfig.getCharset());
            httpCfg.setHttps2way(false);
            httpCfg.setPfxPath(channelConfig.getPfxPath());
            httpCfg.setPfxPass(channelConfig.getPfxPwd());
            httpCfg.setUrl(channelConfig.getBankURL());

            HttpRequester httpRequester = new HttpRequester(httpCfg);
            HttpRep httpRep = httpRequester.sendPostString(httpReq);

            MsgRepModel msgRepModel = new MsgRepModel();
            msgRepModel.setMsg(httpRep.getContent());
            return msgRepModel;
        } catch (UnknownHostException e) {
            logger.error("[渠道系统][前置模块]未知主机名", e);
            throw new CommuException(EnumRtnResult.E030101);
        } catch (HttpHostConnectException e) {
            logger.error("[渠道系统][前置模块]连接超时", e);
            throw new CommuException(EnumRtnResult.E030102);
        } catch (ConnectTimeoutException e) {
            logger.error("[渠道系统][前置模块]连接超时", e);
            throw new CommuException(EnumRtnResult.E030102);
        } catch (SocketTimeoutException e) {
            logger.error("[渠道系统][前置模块]读取超时", e);
            throw new CommuException(EnumRtnResult.E030103);
        } catch (Exception e) {
            logger.error("[渠道系统][前置模块]通信超时", e);
            throw new CommuException(EnumRtnResult.E030104);
        }
    }

}
