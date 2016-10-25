package com.xpay.channel.front.channel.sms.taobao;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.xpay.channel.front.dto.sms.SmsReq;
import com.xpay.channel.front.tongxin.AbsChannelTongXinHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.dto.BaseReqDTO;
import com.xpay.channel.front.tongxin.impl.Https2ChannelHandler;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Created by suxinxin on 16/2/19.
 */
public class TaoBao_TongxinHandler extends AbsChannelTongXinHandler<SmsReq> {

    private static final Logger logger = LoggerFactory.getLogger(TaoBao_TongxinHandler.class);

    @Override
    public byte[] send(SmsReq smsReq, byte[] reqMsg, ChannelConfig channelConfig)
                                                                                 throws CommuException {

        TaoBao_Config taoBaoConfig = (TaoBao_Config) channelConfig;
        TaobaoClient client = new DefaultTaobaoClient(taoBaoConfig.getBankURL(),
            taoBaoConfig.getAppKey(), taoBaoConfig.getAppSecret());
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("");
        req.setSmsType(taoBaoConfig.getNormal());
        req.setSmsFreeSignName(smsReq.getTitle());
        req.setSmsParamString("{\"code\":\"" + "" + "\",\"product\":\"恋指团\"}");
        req.setRecNum(smsReq.getMobileNo());
        req.setSmsTemplateCode(taoBaoConfig.getTemplate());
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
        return new byte[0];
    }
}
