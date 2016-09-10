/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.convert;

import com.xpay.payment.common.dto.customer.SignRepDTO;
import com.xpay.payment.common.dto.customer.SignReqDTO;
import com.xpay.payment.common.vo.agentcollect.SignReqVO;

/**
 * @author qinshou
 * @version $Id: SignConvert.java, v 0.1 16/9/6 下午4:42 sxfans Exp $
 */
public class SignConvert {

    /**
     * 签约请求
     *
     * @param signReqDTO
     * @return
     */
    public static SignRepDTO getSignRepDTO(SignReqDTO signReqDTO) {
        SignRepDTO signRepDTO = new SignRepDTO();

        return null;
    }

    /**
     *
     * @return
     */
    public static SignReqVO getSignReqVO(SignReqDTO signReqDTO) {
        SignReqVO signReqVO = new SignReqVO();
        return signReqVO;
    }
}