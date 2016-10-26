/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.convert;

import com.xpay.channel.common.dto.sms.SmsRepChannelDTO;
import com.xpay.channel.common.dto.sms.SmsReqChannelDTO;
import com.xpay.channel.common.vo.sms.SmsRepVO;
import com.xpay.channel.common.vo.sms.SmsReqVO;

/**
 * @author qinshou
 * @version $Id: SmsConvert.java, v 0.1 16/10/26 上午11:08 sxfans Exp $
 */
public class SmsConvert {

    public static SmsReqVO getSmsReqVO(SmsReqVO smsReqVO, SmsReqChannelDTO smsReqDTO) {
        smsReqVO.setUserId(smsReqDTO.getUserId());
        smsReqVO.setMobileNo(smsReqDTO.getMobileNo());
        smsReqVO.setContent(smsReqDTO.getContent());
        smsReqVO.setTitle(smsReqDTO.getTitle());
        smsReqVO.setExtMap(smsReqDTO.getExtMap());
        return smsReqVO;
    }

    public static SmsRepChannelDTO getSmsRepDTO(SmsRepChannelDTO smsRepChannelDTO, SmsRepVO smsRepVO) {
        smsRepChannelDTO.setUserId(smsRepVO.getUserId());
        smsRepChannelDTO.setSmsStatus(smsRepVO.getSmsStatus());
        return smsRepChannelDTO;
    }
}