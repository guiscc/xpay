/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.channel.sms.taobao.msg;

import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.xpay.channel.common.enums.EnumSMSMapKey;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.dto.sms.SmsRepFrontDTO;
import com.xpay.channel.front.dto.sms.SmsReqFrontDTO;
import com.xpay.channel.front.msg.AbsChannelMsgHandler;
import com.xpay.channel.front.msg.model.MsgRepModel;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.enums.EnumRtnResult;
import com.xpay.common.enums.EnumRtnStatus;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author qinshou
 * @version $Id: TaoBao_SmsMsgHandler.java, v 0.1 16/10/24 下午8:12 sxfans Exp $
 */
public class TaoBao_SmsMsgHandler extends AbsChannelMsgHandler<SmsReqFrontDTO, SmsRepFrontDTO> {

    @Override
    public MsgReqModel builderMsg(SmsReqFrontDTO smsReqDTO, ChannelConfig channelConfig) throws BuildMsgException {
        Map<EnumSMSMapKey, String> extMap = smsReqDTO.getSmsExtMap();
        String context = "{\"code\":\"" + extMap.get(EnumSMSMapKey.SMSCODE) + "\",\"time\":\""
                         + extMap.get(EnumSMSMapKey.TIME) + "\"}";
        try {
            byte[] bytes = context.getBytes(channelConfig.getCharset());
            MsgReqModel msgReqModel = new MsgReqModel();
            msgReqModel.setMsgBytes(bytes);
            return msgReqModel;
        } catch (UnsupportedEncodingException e) {
            throw new BuildMsgException(EnumRtnResult.E030201);
        }
    }

    @Override
    public SmsRepFrontDTO resolveMsg(SmsReqFrontDTO baseReqDTO, MsgRepModel rtnMsg, ChannelConfig channelConfig)
                                                                                           throws ResolveMsgException {
        try {
            ByteArrayInputStream bi = new ByteArrayInputStream(rtnMsg.getMsgBytes());
            ObjectInputStream oi = new ObjectInputStream(bi);
            AlibabaAliqinFcSmsNumSendResponse rsp = (AlibabaAliqinFcSmsNumSendResponse) oi
                .readObject();
            SmsRepFrontDTO smsRepDTO = new SmsRepFrontDTO();
            if (rsp == null) {
                throw new ResolveMsgException(EnumRtnResult.E030202);
            }
            smsRepDTO.setBankRtnMsg(rsp.getSubCode());
            smsRepDTO.setBankRtnCode(rsp.getMsg());
            if (rsp.isSuccess()) {
                smsRepDTO.setSmsStatus(EnumRtnStatus.SUCCESS);
            } else {
                smsRepDTO.setSmsStatus(EnumRtnStatus.FAIL);
            }
            return smsRepDTO;
        } catch (IOException e) {
            throw new ResolveMsgException(EnumRtnResult.E030202);
        } catch (ClassNotFoundException e) {
            throw new ResolveMsgException(EnumRtnResult.E030202);
        }
    }
}