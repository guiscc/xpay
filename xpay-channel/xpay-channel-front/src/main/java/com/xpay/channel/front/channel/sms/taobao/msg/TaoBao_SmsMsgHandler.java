/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.channel.sms.taobao.msg;

import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.xpay.channel.common.enums.EnumExtMapKey;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.dto.sms.SmsRepFrontDTO;
import com.xpay.channel.front.dto.sms.SmsReqFrontDTO;
import com.xpay.channel.front.msg.AbsChannelMsgHandler;
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
    public byte[] builderMsg(SmsReqFrontDTO smsReqDTO, ChannelConfig channelConfig) throws BuildMsgException {
        Map<EnumExtMapKey, String> extMap = smsReqDTO.getExtMap();
        String context = "{\"code\":\"" + extMap.get(EnumExtMapKey.SMSCODE) + "\",\"product\":\""
                         + extMap.get(EnumExtMapKey.SMS_PRODUCT_NAME) + "\"}";
        try {
            byte[] bytes = context.getBytes(channelConfig.getCharset());
            return bytes;
        } catch (UnsupportedEncodingException e) {
            throw new BuildMsgException(EnumRtnResult.E030201);
        }
    }

    @Override
    public SmsRepFrontDTO resolveMsg(SmsReqFrontDTO baseReqDTO, byte[] rtnMsg, ChannelConfig channelConfig)
                                                                                           throws ResolveMsgException {
        try {
            ByteArrayInputStream bi = new ByteArrayInputStream(rtnMsg);
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