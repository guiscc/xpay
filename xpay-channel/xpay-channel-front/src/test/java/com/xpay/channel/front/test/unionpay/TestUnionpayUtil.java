/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.test.unionpay;


import com.xpay.channel.front.channel.agentcollect.unionpay.Unionpay_Config;
import com.xpay.channel.front.channel.agentcollect.unionpay.util.UnionpayUtil;
import com.xpay.channel.front.test.BaseTest;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.enums.EnumCardType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinshou
 * @version $Id: TestUnionpayUtil.java, v 0.1 16/11/23 下午3:57 sxfans Exp $
 */
public class TestUnionpayUtil extends BaseTest {

    @Test
    public void cardEncry() throws Exception {
        Unionpay_Config channelConfig = new Unionpay_Config();
        channelConfig.setPfxPath("/export/safefile/unionpay/acp_test_sign.pfx");
        channelConfig.setEncCerPath("/export/safefile/unionpay/acp_test_enc.cer");
        channelConfig.setPfxPwd("000000");
        channelConfig.setCharset("UTF-8");
        System.out.println(UnionpayUtil.getCertId(channelConfig,false));
//        String str = UnionpayUtil.encryptCardNo("6216261000000000018" ,channelConfig);
//        System.out.println(str);
    }

    @Test
    public void dataEncry(){
        Map<String, String> customerInfoMap = new HashMap();
        customerInfoMap.put("certifTp", "01");
        customerInfoMap.put("certifId", "");
        customerInfoMap.put("customerNm", "");
        customerInfoMap.put("phoneNo", "");
//        if (EnumCardType.CREDIT.equals(req.getCardType())) {
//            customerInfoMap.put("cvn2", req.getCvv2());
//            customerInfoMap.put("expired", req.getExpiredDate());
//        }

    }
}