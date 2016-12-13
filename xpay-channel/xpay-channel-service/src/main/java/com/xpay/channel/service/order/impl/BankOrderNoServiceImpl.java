/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.order.impl;

import com.xpay.channel.service.order.OrderNoService;
import com.xpay.common.utils.DateUtil;
import com.xpay.common.utils.sequence.Sequence;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 时间(yyyyMMddHHmmss)+版本(0)+业务标识(000)+分表(00)+流水(6位)
 *
 * @author qinshou
 * @version $Id: BankOrderNoServiceImpl.java, v 0.1 16/12/7 下午2:15 sxfans Exp $
 */
@Service(value="bankOrderNoService")
public class BankOrderNoServiceImpl implements OrderNoService {

    @Resource(name = "channelRandomSequeue")
    private Sequence sequence;

    @Override
    public String getOrderNo() {
        String dateStr= DateUtil.DateStampToStringNoSp(new Date());
        String version = "0";
        String tradeType = "001";
        String tableCode = "00";
        String seqNo = sequence.getSeq("", 6);
        String seq = dateStr + version + tradeType + tableCode + seqNo;
        return seq;
    }
}