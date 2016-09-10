/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.convert;

import com.xpay.payment.common.dto.customer.BreakSignRepDTO;
import com.xpay.payment.common.dto.customer.BreakSignReqDTO;
import com.xpay.payment.common.vo.agentcollect.BreakSignReqVO;

/**
 * @author qinshou
 * @version $Id: BreakSignConvert.java, v 0.1 16/9/6 下午4:44 sxfans Exp $
 */
public class BreakSignConvert {

    /**
     * 解约
     *
     * @return
     */
    private static BreakSignRepDTO getBreakSignRepDTO(BreakSignReqDTO breakSignReqDTO) {
        BreakSignRepDTO breakSignRepDTO = new BreakSignRepDTO();

        return breakSignRepDTO;
    }

    /**
     * 解约
     * @param breakSignReqDTO
     * @return
     */
    private static BreakSignReqVO getBreakSignReqVO(BreakSignReqDTO breakSignReqDTO) {
        BreakSignReqVO breakSignReqVO = new BreakSignReqVO();

        return breakSignReqVO;
    }
}