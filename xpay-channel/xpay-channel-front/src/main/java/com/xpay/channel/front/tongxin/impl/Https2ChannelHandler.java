package com.xpay.channel.front.tongxin.impl;

import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.common.enums.EnumSysRtnCode;
import com.xpay.channel.common.enums.EnumTradeStatus;
import com.xpay.channel.common.exception.CommuException;
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
public class Https2ChannelHandler<REQ extends BaseReqDTO> extends AbsChannelTongXinHandler {
    private static final Logger logger = LoggerFactory.getLogger(Https2ChannelHandler.class);
    @Override
    public byte[] send(BaseReqDTO baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        try {
            HttpReq httpReq = new HttpReq(); //创建http请求数据
            httpReq.setRequestBody(new String(reqMsg, channelConfig.getCharset()));
            httpReq.setHeadMap(baseReqDTO.getHeadMap());

            HttpCfg httpCfg = new HttpCfg();
            httpCfg.setCharset(channelConfig.getCharset());
            httpCfg.setHttps2way(true);
            httpCfg.setPfxPath(baseReqDTO.getPfxPath());
            httpCfg.setPfxPass(baseReqDTO.getPfxPass());
            httpCfg.setUrl(channelConfig.getBankURL());



            HttpRequester httpRequester = new HttpRequester(httpCfg);//
            HttpRep httpRep = httpRequester.sendPostString(httpReq);
            return httpRep.getContent().getBytes(channelConfig.getCharset());
        } catch (UnknownHostException e) {
            logger.error("[渠道系统][前置模块]未知主机名",e);
            throw new CommuException(EnumSysRtnCode.C0003, EnumTradeStatus.FAIL);
        } catch (HttpHostConnectException e) {
            logger.error("[渠道系统][前置模块]连接超时",e);
            throw new CommuException(EnumSysRtnCode.C0001, EnumTradeStatus.FAIL);
        } catch (ConnectTimeoutException e) {
            logger.error("[渠道系统][前置模块]连接超时",e);
            throw new CommuException(EnumSysRtnCode.C0005, EnumTradeStatus.FAIL);
        } catch (SocketTimeoutException e) {
            logger.error("[渠道系统][前置模块]读取超时",e);
            throw new CommuException(EnumSysRtnCode.C0002, EnumTradeStatus.UNKNOW);
        } catch (Exception e) {
            logger.error("[渠道系统][前置模块]通信超时",e);
            throw new CommuException(EnumSysRtnCode.C9999, EnumTradeStatus.UNKNOW);
        }
    }

}
