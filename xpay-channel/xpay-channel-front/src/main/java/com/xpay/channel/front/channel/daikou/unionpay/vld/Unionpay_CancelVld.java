package com.xpay.channel.front.channel.daikou.unionpay.vld;

import com.xpay.channel.common.dto.daikou.CancelReqDto;
import com.xpay.channel.common.dto.daikou.RefundReqDto;
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
public class Unionpay_CancelVld extends BaseValidateImpl<CancelReqDto> {

    @Override
    public void validate(CancelReqDto param) throws VldException {
        super.validate(param);

        if(StringUtils.isBlank(param.getChannelRemark().getMerchantNo())){
            throw new VldException(EnumSysRtnCode.V1023 , EnumTradeStatus.FAIL) ;
        }

        if(StringUtils.isBlank(param.getChannelCancelNo())){
            throw new VldException(EnumSysRtnCode.V1104 , EnumTradeStatus.FAIL) ;
        }

        if(param.getChannelCreateDate() == null){
            throw new VldException(EnumSysRtnCode.V1132 , EnumTradeStatus.FAIL) ;
        }

        if(StringUtils.isBlank(param.getChannelRemark().getPfxPath())){
            throw new VldException(EnumSysRtnCode.V1024 , EnumTradeStatus.FAIL) ;
        }

        if(StringUtils.isBlank(param.getChannelRemark().getPwd())){
            throw new VldException(EnumSysRtnCode.V1133 , EnumTradeStatus.FAIL) ;
        }

        if(StringUtils.isBlank(param.getOriBankNo())){
            throw new VldException(EnumSysRtnCode.V1106 , EnumTradeStatus.FAIL) ;
        }
    }
}
