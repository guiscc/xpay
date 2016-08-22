package com.xpay.channel.common.dto.quick;

import com.xpay.channel.common.enums.EnumRepairSource;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Created by suxinxin on 16/2/5.
 */
public class PayQueryReqDTO extends BaseQuickReqDTO {

	/**
     * 银行流水号
     */
    private String bankNo ;

    /**
     * 原订单号
     */
    private String oriChannelPayNo;

    /**
     * 原业务订单号
     */
    private String oriPayNo;

    /**
     * 渠道创建时间
     */
    private Date channelCreateTime ;
    /**
     * 渠道完成时间
     */
    private Date channelFinishTime ;

    /**
     * 银行完成时间
     */
    private Date  bankFinishTime;
    
    /**
     * 补单来源
     */
    private EnumRepairSource repairSource;

    public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getOriChannelPayNo() {
		return oriChannelPayNo;
	}

	public void setOriChannelPayNo(String oriChannelPayNo) {
		this.oriChannelPayNo = oriChannelPayNo;
	}

	public String getOriPayNo() {
		return oriPayNo;
	}

	public void setOriPayNo(String oriPayNo) {
		this.oriPayNo = oriPayNo;
	}

	public Date getChannelCreateTime() {
		return channelCreateTime;
	}

	public void setChannelCreateTime(Date channelCreateTime) {
		this.channelCreateTime = channelCreateTime;
	}

	public Date getChannelFinishTime() {
		return channelFinishTime;
	}

	public void setChannelFinishTime(Date channelFinishTime) {
		this.channelFinishTime = channelFinishTime;
	}

	public Date getBankFinishTime() {
		return bankFinishTime;
	}

	public void setBankFinishTime(Date bankFinishTime) {
		this.bankFinishTime = bankFinishTime;
	}

	public EnumRepairSource getRepairSource() {
		return repairSource;
	}

	public void setRepairSource(EnumRepairSource repairSource) {
		this.repairSource = repairSource;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
