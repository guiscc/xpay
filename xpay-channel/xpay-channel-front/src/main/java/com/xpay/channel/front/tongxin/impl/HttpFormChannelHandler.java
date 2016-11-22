package com.xpay.channel.front.tongxin.impl;

import com.xpay.channel.common.enums.EnumMsgRepType;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.front.msg.model.MsgRepModel;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.tongxin.AbsChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.enums.EnumRtnResult;
import com.xpay.common.utils.HttpCfg;
import com.xpay.common.utils.HttpRep;
import com.xpay.common.utils.HttpReq;
import com.xpay.common.utils.HttpRequester;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * http通信类组件
 * Created by suxinxin on 14/12/25.
 */
public class HttpFormChannelHandler<REQ extends BaseReqFrontDTO>
                                                                 extends
                                                                 AbsChannelTongXinHandler<BaseReqFrontDTO> {

    private static final Logger logger = LoggerFactory.getLogger(HttpFormChannelHandler.class);

    @Override
    public MsgRepModel send(BaseReqFrontDTO baseReqFrontDTO, MsgReqModel reqMsg,
                            ChannelConfig channelConfig) throws CommuException {
        try {
            HttpCfg httpCfg = new HttpCfg();
            httpCfg.setUrl(channelConfig.getBankURL());
            httpCfg.setConnTimeOut(Integer.parseInt(channelConfig.getConnTimeOut()));
            httpCfg.setReadTimeOut(Integer.parseInt(channelConfig.getReadTimeOut()));
            httpCfg.setPort(443);
            httpCfg.setProtocol(HttpCfg.HTTPS);
            httpCfg.setHttps2way(false);
            httpCfg.setCharset(channelConfig.getCharset());

            HttpRequester httpRequester = new HttpRequester(httpCfg);
            HttpReq httpReq = new HttpReq();
            httpReq.setParamMap(baseReqFrontDTO.getFormMap());
            HttpRep httpRep = httpRequester.sendPostForm(httpReq);
            MsgRepModel msgRepModel = new MsgRepModel();
            msgRepModel.setMsg(httpRep.getContent());
            msgRepModel.setMsgRepType(EnumMsgRepType.STR);
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

//    /**
//     *
//     * @param map
//     * @return
//     */
//    private Map<String, String> getParamMap(Map<String, Object> map) {
//        Map<String, String> paramMap = new HashMap<>();
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            paramMap.put(entry.getKey(), entry.getValue() + "");
//        }
//        return paramMap;
//    }

}