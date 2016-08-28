package com.xpay.trade.biz.convert;

import com.xpay.trade.common.dto.UpOrderStatusRepDTO;
import com.xpay.trade.common.dto.UpOrderStatusReqDTO;
import com.xpay.trade.common.vo.UpOrderStatusRepVO;
import com.xpay.trade.common.vo.UpOrderStatusReqVO;

/**
 * Created by sxfans on 16/8/20.
 */
public class UpOrderStatusConvert {
    
    public static UpOrderStatusReqVO getUpOrderStatusReqVO(UpOrderStatusReqDTO upOrderStatusReqDTO) {
        UpOrderStatusReqVO upOrderStatusReqVO = new UpOrderStatusReqVO();
        upOrderStatusReqVO.setBizOrderNo(upOrderStatusReqDTO.getBizOrderNo());
        upOrderStatusReqVO.setOrderStatus(upOrderStatusReqDTO.getOrderStatus());
        return upOrderStatusReqVO;
    }

    public static UpOrderStatusRepDTO getUpOrderStatusRepDTO(UpOrderStatusRepDTO upOrderStatusRepDTO,UpOrderStatusRepVO upOrderStatusRepVO) {
        upOrderStatusRepDTO.setOrderStatus(upOrderStatusRepVO.getOrderStatus());
        upOrderStatusRepDTO.setBizOrderNo(upOrderStatusRepVO.getBizOrderNo());
        return upOrderStatusRepDTO;
    }
}
