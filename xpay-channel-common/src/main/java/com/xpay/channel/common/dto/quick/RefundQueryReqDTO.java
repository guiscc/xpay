package com.xpay.channel.common.dto.quick;

import com.xpay.channel.common.enums.EnumRepairSource;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月3日 下午2:43:18
 */
public class RefundQueryReqDTO extends BaseQuickReqDTO {
	/**
     * 退款金额
     */
    private BigDecimal amount;

    /**
     * 原请求退款单号
     */
    private String oriRefundNo;

    /**
     * 原渠道退款单号
     */
    private String oriBankRefundNo;

    /**
     * 交易完成时间
     */
    private Date channelPayFinishTime;
    
    /**
     * 退款单创建时间
     */
    private Date channelCreateTime ;
    
    /**
     * 原交易单创建时间
     */
    private Date oriChannelPayCreateTime ;
    
    /**
     * 订单创建时间
     */
    private Date createDateTime;
    
    /**
     * 补单来源
     */
    private EnumRepairSource repairSource;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getOriRefundNo() {
		return oriRefundNo;
	}

	public void setOriRefundNo(String oriRefundNo) {
		this.oriRefundNo = oriRefundNo;
	}

	public String getOriBankRefundNo() {
		return oriBankRefundNo;
	}

	public void setOriBankRefundNo(String oriBankRefundNo) {
		this.oriBankRefundNo = oriBankRefundNo;
	}

	public Date getChannelPayFinishTime() {
		return channelPayFinishTime;
	}

	public void setChannelPayFinishTime(Date channelPayFinishTime) {
		this.channelPayFinishTime = channelPayFinishTime;
	}

	public Date getChannelCreateTime() {
		return channelCreateTime;
	}

	public void setChannelCreateTime(Date channelCreateTime) {
		this.channelCreateTime = channelCreateTime;
	}

	public Date getOriChannelPayCreateTime() {
		return oriChannelPayCreateTime;
	}

	public void setOriChannelPayCreateTime(Date oriChannelPayCreateTime) {
		this.oriChannelPayCreateTime = oriChannelPayCreateTime;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public EnumRepairSource getRepairSource() {
		return repairSource;
	}

	public void setRepairSource(EnumRepairSource repairSource) {
		this.repairSource = repairSource;
	}
    
    
}
