package com.xpay.channel.front.channel.daikou.unionpay;

import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.common.enums.EnumSysRtnCode;
import com.xpay.channel.common.enums.EnumTradeStatus;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.util.JsonUtil;
import com.xpay.channel.front.channel.daikou.unionpay.util.UnionpayUtil;
import com.xpay.channel.front.tongxin.impl.Https2ChannelHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.utils.HttpCfg;
import com.xpay.common.utils.HttpRep;
import com.xpay.common.utils.HttpReq;
import com.xpay.common.utils.HttpRequester;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suxinxin on 16/2/19.
 */
public class Unionpay_TongxinHandler<REQ extends BaseReqDTO> extends Https2ChannelHandler {

    private static final Logger logger = LoggerFactory.getLogger(Unionpay_TongxinHandler.class) ;

    @Override
    public byte[] send(BaseReqDTO baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        byte results [] = null ;
        try {
            String url = baseReqDTO.getBankUrl() ;
            Map<String , String> data = new HashMap<String , String>() ;
            String str = new String(reqMsg , channelConfig.getCharset()) ;
            logger.info("#####传递的参数为:" + str);
            data = JsonUtil.jsonTomMap(str) ;

            HttpCfg httpCfg = new HttpCfg();
            httpCfg.setUrl(baseReqDTO.getBankUrl());
            httpCfg.setConnTimeOut(10000);
            httpCfg.setReadTimeOut(2000);
            httpCfg.setPort(443);
            httpCfg.setProtocol(HttpCfg.HTTPS);
            httpCfg.setHttps2way(false);
            httpCfg.setUrl(url);
//            String signBytes = UnionpayUtil.sign(data, "UTF-8" , req); //签名
//            data.put("signature", signBytes); //签名
            logger.info("#####发送信息:" + data);

            HttpRequester httpRequester = new HttpRequester(httpCfg);
            HttpReq httpReq = new HttpReq();
            httpReq.setParamMap(data);
            HttpRep httpRep = httpRequester.sendPostForm(httpReq);
            Map<String, String> map = UnionpayUtil.parseQString(httpRep.getContent());
            logger.info("返回信息:" + map);
            if(map != null && !map.isEmpty()){
                results = JsonUtil.mapToStr(map).getBytes(channelConfig.getCharset()) ;
            }
//            boolean signFlag = UnionpayUtil.verSign(map);
//            System.out.println("返回签名信息:" + signFlag);
        }catch (Exception e){
            logger.error("#####通信错误." , e) ;
            throw new CommuException(EnumSysRtnCode.C9999 , EnumTradeStatus.UNKNOW) ;
        }
        return results ;
    }
}
