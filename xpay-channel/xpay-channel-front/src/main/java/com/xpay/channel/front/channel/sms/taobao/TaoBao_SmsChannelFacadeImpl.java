/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.channel.sms.taobao;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.channel.sms.SmsChannelFacadeImpl;
import com.xpay.channel.front.dto.sms.SmsRep;
import com.xpay.channel.front.dto.sms.SmsReq;
import com.xpay.channel.front.executor.AbsChannelExecutorImpl;
import com.xpay.common.enums.EnumChannelType;

/**
 * @author qinshou
 * @version $Id: TaoBao_SmsChannelFacadeImpl.java, v 0.1 16/10/24 下午5:30 sxfans Exp $
 */
public class TaoBao_SmsChannelFacadeImpl extends SmsChannelFacadeImpl {

    @Override
    public SmsRep sendSMS(SmsReq smsReq) throws BuildMsgException, ResolveMsgException, VldException, CommuException {
        AbsChannelExecutorImpl<SmsReq, SmsRep> channelActionProcess = new AbsChannelExecutorImpl<SmsReq, SmsRep>();
        channelActionProcess.setChannelValidate(this.getChannelValidateHandler().get(EnumChannelType.SMS));
        channelActionProcess.setChannelTongXinHandler(this.getChannelTongXinHandler());
        channelActionProcess.setChannelMsgHandler(this.getChannelMsgHandler().get(EnumChannelType.SMS));
        channelActionProcess.setChannelConfig(this.getChannelConfig());
        SmsRep smsRep = channelActionProcess.doProcess(smsReq);
        return smsRep;
    }

//    @Override
//    public SmsRep sendSMS(SmsReq smsReq) {
//
//
//        String smsUrl = "http://gw.api.taobao.com/router/rest";
//        String appKey = "23359019";
//        String appSecret = "6a42f98a82496ec9e7a6ec9a82c97a5a";
//        String templateName = "SMS_8845006";
//        String smsType = "normal";
//
//        TaobaoClient client = new DefaultTaobaoClient(smsUrl, appKey, appSecret);
//        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//        req.setExtend("");
//        req.setSmsType(smsType);
//        req.setSmsFreeSignName(smsReq.getTitle());
//        req.setSmsParamString("{\"code\":\"" + "" + "\",\"product\":\"恋指团\"}");
//        req.setRecNum(smsReq.getMobileNo());
//        req.setSmsTemplateCode(templateName);
//        AlibabaAliqinFcSmsNumSendResponse rsp;
//        try {
//            rsp = client.execute(req);
//            System.out.println(rsp.getBody());
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        SmsChannelFacade smsChannelFacade = new TaoBao_SmsChannelFacadeImpl();
//        SmsReq smsReq = new SmsReq();
//        smsReq.setMobileNo("18317888059");
//        smsReq.setTitle("注册验证");
//        smsChannelFacade.sendSMS(smsReq);
//    }
}