package com.xpay.trade.biz.convert;

import com.xpay.trade.common.dto.QueryPayRepDTO;
import com.xpay.trade.common.dto.QueryPayReqDTO;
import com.xpay.trade.common.vo.QueryPayRepVO;
import com.xpay.trade.common.vo.QueryPayReqVO;

/**
 * Created by sxfans on 16/8/12.
 */
public class QueryPayConvert {

    public QueryPayRepDTO getQueryPayRepDTO(QueryPayRepVO queryPayRepVO) {
        QueryPayRepDTO queryPayRepDTO = new QueryPayRepDTO();
        return queryPayRepDTO;
    }


    public QueryPayReqVO getQueryPayReqVO(QueryPayReqDTO queryPayReqDTO) {
        QueryPayReqVO queryPayReqVO = new QueryPayReqVO();
        return queryPayReqVO;
    }
}
