package com.xpay.channel.front.channel.daikou.unionpay.vld;

import com.xpay.channel.common.dto.daikou.RealNameAuthReqDto;
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
public class Unionpay_AuthVld extends BaseValidateImpl<RealNameAuthReqDto> {

    @Override
    public void validate(RealNameAuthReqDto param) throws VldException {
        super.validate(param);

        if(StringUtils.isBlank(param.getChannelRemark().getMerchantNo())){
            throw new VldException(EnumSysRtnCode.V1023 , EnumTradeStatus.FAIL) ;
        }

        if(StringUtils.isBlank(param.getChannelOrderNo())){
            throw new VldException(EnumSysRtnCode.V1003 , EnumTradeStatus.FAIL) ;
        }

        if(param.getChannelCreateDate() == null){
            throw new VldException(EnumSysRtnCode.V1132 , EnumTradeStatus.FAIL) ;
        }

        if(StringUtils.isBlank(param.getCertNo())){
            throw new VldException(EnumSysRtnCode.V1010 , EnumTradeStatus.FAIL) ;
        }

        if(StringUtils.isBlank(param.getHolderName())){
            throw new VldException(EnumSysRtnCode.V1008 , EnumTradeStatus.FAIL) ;
        }

        if(StringUtils.isBlank(param.getMobileNo())){
            throw new VldException(EnumSysRtnCode.V1015 , EnumTradeStatus.FAIL) ;
        }

        if(StringUtils.isBlank(param.getChannelRemark().getPfxPath())){
            throw new VldException(EnumSysRtnCode.V1024 , EnumTradeStatus.FAIL) ;
        }

        if(StringUtils.isBlank(param.getChannelRemark().getPwd())){
            throw new VldException(EnumSysRtnCode.V1133 , EnumTradeStatus.FAIL) ;
        }
    }
}
