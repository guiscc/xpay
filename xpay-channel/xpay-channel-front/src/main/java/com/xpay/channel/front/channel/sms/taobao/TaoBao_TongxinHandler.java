package com.xpay.channel.front.channel.sms.taobao;

import java.io.*;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.xpay.channel.front.dto.sms.SmsReqFrontDTO;
import com.xpay.channel.front.msg.model.MsgRepModel;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.tongxin.AbsChannelTongXinHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Created by suxinxin on 16/2/19.
 */
public class TaoBao_TongxinHandler extends AbsChannelTongXinHandler<SmsReqFrontDTO> {

    private static final Logger logger = LoggerFactory.getLogger(TaoBao_TongxinHandler.class);

    @Override
    public MsgRepModel send(SmsReqFrontDTO smsReqDTO, MsgReqModel msgReqModel, ChannelConfig channelConfig)
                                                                                 throws CommuException {
        try {
            TaoBao_Config taoBaoConfig = (TaoBao_Config) channelConfig;
            TaobaoClient client = new DefaultTaobaoClient(taoBaoConfig.getBankURL(),
                taoBaoConfig.getAppKey(), taoBaoConfig.getAppSecret());
            AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
            req.setExtend(smsReqDTO.getUserId());
            req.setSmsType(taoBaoConfig.getNormal());
            req.setSmsFreeSignName(smsReqDTO.getTitle());
            req.setSmsParamString(new String(msgReqModel.getMsgBytes(), channelConfig.getCharset()));
            req.setRecNum(smsReqDTO.getMobileNo());
            req.setSmsTemplateCode(taoBaoConfig.getTemplate());
            AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream ob = new ObjectOutputStream(byteArrayOutputStream);
            ob.writeObject(rsp);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            ob.flush();
            ob.close();
            MsgRepModel msgRepModel = new MsgRepModel();
            msgRepModel.setMsgBytes(bytes);
            return msgRepModel;
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
