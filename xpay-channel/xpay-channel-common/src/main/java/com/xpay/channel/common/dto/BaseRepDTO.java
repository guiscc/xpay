package com.xpay.channel.common.dto;

import com.xpay.channel.common.enums.EnumTradeStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by suxinxin on 16/2/5.
 */
public class BaseRepDTO {
    /**
     * 银行返回码
     */
    private String rtnCode;

    /**
     * 银行返回信息
     */
    private String rtnMsg;
    
    /**
     * 银行返回流水号
     */
    private String bankNo ;
    
    /**
     * 处理状态
     */
    private EnumTradeStatus tradeStatus ;
    
    /**
     * 交易完成时间
     */
    private Date channelFinishTime;

    /**
     * 银行返回时间
     */
    private Date  bankFinishTime;
    
    /**
     * 机构
     */
    private String instCode;
    
    /**
     * 返回时间
     */
    private Date repTime ;

    /**
     * 备注字段
     */
    private Map<String , String> map = new HashMap<String , String>() ;
    
    
    public Date getRepTime() {
		return repTime;
	}

	public void setRepTime(Date repTime) {
		this.repTime = repTime;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public String getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(String rtnCode) {
		this.rtnCode = rtnCode;
	}

	public String getRtnMsg() {
		return rtnMsg;
	}

	public void setRtnMsg(String rtnMsg) {
		this.rtnMsg = rtnMsg;
	}

	public EnumTradeStatus getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(EnumTradeStatus tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
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

	public String getInstCode() {
		return instCode;
	}

	public void setInstCode(String instCode) {
		this.instCode = instCode;
	}

	@Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this) ;
    }
}
