/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service.impl;

import com.xpay.common.utils.DateUtil;
import com.xpay.common.utils.sequence.Sequence;
import com.xpay.payment.service.OrderNoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: OrderNoServiceImpl.java, v 0.1 16/12/9 上午9:51 sxfans Exp $
 */
@Service
public class OrderNoServiceImpl implements OrderNoService {

    @Resource
    private Sequence sequence;

    @Override
    public String getOrderNo() {

        String dateStr= DateUtil.DateStampToStringNoSp(new Date());
        String version = "0";
        String tradeType = "001";
        String tableCode = "00";
        String seqNo = sequence.getSeq("", 6);
        String seq = "P"+dateStr + version + tradeType + tableCode + seqNo;
        return seq;
    }
}