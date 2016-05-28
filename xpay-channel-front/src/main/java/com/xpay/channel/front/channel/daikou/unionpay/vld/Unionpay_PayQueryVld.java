package com.xpay.channel.front.channel.daikou.unionpay.vld;

import com.xpay.channel.common.dto.daikou.PayQueryReqDto;
import com.xpay.channel.common.dto.daikou.PayReqDto;
import com.xpay.channel.common.enums.EnumSysRtnCode;
import com.xpay.channel.common.enums.EnumTradeStatus;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.vld.BaseValidateImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午2:05
 */
public class Unionpay_PayQueryVld extends BaseValidateImpl<PayQueryReqDto> {

    @Override
    public void validate(PayQueryReqDto param) throws VldException {
        super.validate(param);

        if(StringUtils.isBlank(param.getChannelRemark().getMerchantNo())){
            throw new VldException(EnumSysRtnCode.V1023 , EnumTradeStatus.UNKNOW) ;
        }

        if(StringUtils.isBlank(param.getOriChannelOrderNo())){
            throw new VldException(EnumSysRtnCode.V1104 , EnumTradeStatus.UNKNOW) ;
        }

        if(param.getChannelCreateDate() == null){
            throw new VldException(EnumSysRtnCode.V1132 , EnumTradeStatus.UNKNOW) ;
        }

        if(StringUtils.isBlank(param.getChannelRemark().getPfxPath())){
            throw new VldException(EnumSysRtnCode.V1024 , EnumTradeStatus.UNKNOW) ;
        }

        if(StringUtils.isBlank(param.getChannelRemark().getPwd())){
            throw new VldException(EnumSysRtnCode.V1133 , EnumTradeStatus.UNKNOW) ;
        }

    }
}
