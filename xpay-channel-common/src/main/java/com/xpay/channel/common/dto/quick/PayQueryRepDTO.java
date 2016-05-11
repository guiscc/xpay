package com.xpay.channel.common.dto.quick;

import com.xpay.channel.common.enums.EnumTradeStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * Created by suxinxin on 16/2/5.
 */
public class PayQueryRepDTO extends BaseQuickRepDTO {

    /**
     * 交易状态
     */
    private EnumTradeStatus tradeStatus;

    /**
     * 原请求支付单号
     */
    private String oriPayNo ;
    
    /**
     * 原渠道单号
     */
    private String oriChannelPayNo ;

    /**
     * 交易金额
     */
    private BigDecimal amount;

    public EnumTradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(EnumTradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getOriPayNo() {
		return oriPayNo;
	}

	public void setOriPayNo(String oriPayNo) {
		this.oriPayNo = oriPayNo;
	}

	public String getOriChannelPayNo() {
		return oriChannelPayNo;
	}

	public void setOriChannelPayNo(String oriChannelPayNo) {
		this.oriChannelPayNo = oriChannelPayNo;
	}

	public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
