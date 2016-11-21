package com.xpay.channel.front.tongxin.impl;

import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.tongxin.AbsChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.utils.HttpCfg;
import com.xpay.common.utils.HttpRep;
import com.xpay.common.utils.HttpReq;
import com.xpay.common.utils.HttpRequester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public byte[] send(BaseReqFrontDTO baseReqFrontDTO, MsgReqModel reqMsg, ChannelConfig channelConfig)
                                                                                                   throws CommuException {
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
            httpReq.setParamMap(getParamMap(baseReqFrontDTO.getFormMap()));
            HttpRep httpRep = httpRequester.sendPostForm(httpReq);
            return httpRep.getContent().getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param map
     * @return
     */
    private Map<String,String> getParamMap(Map<String,Object> map){
        Map<String,String> paramMap = new HashMap<>();
        for(Map.Entry<String,Object> entry : map.entrySet()){
            paramMap.put(entry.getKey(),entry.getValue()+"");
        }
        return paramMap;
    }

}