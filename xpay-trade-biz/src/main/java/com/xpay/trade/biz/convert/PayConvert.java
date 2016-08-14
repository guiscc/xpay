package com.xpay.trade.biz.convert;

import com.xpay.trade.common.dto.PayRepDTO;
import com.xpay.trade.common.dto.PayReqDTO;
import com.xpay.trade.common.vo.PayRepVO;
import com.xpay.trade.common.vo.PayReqVO;

/**
 * Created by sxfans on 16/8/12.
 */
public class PayConvert {

    public static PayReqVO getPayReqVO(PayReqDTO payReqDTO) {
        PayReqVO payReqVO = new PayReqVO();
        return payReqVO;
    }

    public static PayRepDTO getPayRepDTO(PayRepVO payRepVO) {
        PayRepDTO payRepDTO = new PayRepDTO();
        return payRepDTO;
    }
}