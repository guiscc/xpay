package com.xpay.channel.front.channel.agentcollect.unionpay;

import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.tongxin.impl.Https2ChannelHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by suxinxin on 16/2/19.
 */
public class Unionpay_TongxinHandler<REQ extends BaseReqFrontDTO> extends Https2ChannelHandler<REQ> {

    private static final Logger logger = LoggerFactory.getLogger(Unionpay_TongxinHandler.class);

    @Override
    public byte[] send(BaseReqFrontDTO baseReqFrontDTO, byte[] reqMsg, ChannelConfig channelConfig)
                                                                                         throws CommuException {

        super.send(baseReqFrontDTO, reqMsg, channelConfig);
        byte results[] = null;
        Map<String, String> data = new HashMap<String, String>();
        String str = null;
        try {
            str = new String(reqMsg, channelConfig.getCharset());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //        data = JsonUtil.jsonTomMap(str);
        //
        //        HttpCfg httpCfg = new HttpCfg();
        //        httpCfg.setUrl(channelConfig.getBankURL());
        //        httpCfg.setConnTimeOut(10000);
        //        httpCfg.setReadTimeOut(2000);
        //        httpCfg.setPort(443);
        //        httpCfg.setProtocol(HttpCfg.HTTPS);
        //        httpCfg.setHttps2way(false);
        //
        //        HttpRequester httpRequester = new HttpRequester(httpCfg);
        //        HttpReq httpReq = new HttpReq();
        //        httpReq.setParamMap(data);
        //        HttpRep httpRep = httpRequester.sendPostForm(httpReq);
        //        Map<String, String> map = UnionpayUtil.parseQString(httpRep.getContent());
        //        if (map != null && !map.isEmpty()) {
        //            results = JsonUtil.mapToStr(map).getBytes(channelConfig.getCharset());
        //        }
        //boolean signFlag = UnionpayUtil.verSign(map);
        //System.out.println("返回签名信息:" + signFlag);
        return results;
    }
}
