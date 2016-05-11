package com.xpay.channel.common.dto.quick;

/**
 * 解约rep
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月2日 下午5:19:36
 */
public class BreakSignRepDTO extends BaseQuickRepDTO {
	/**
	 * 业务请求解约号
	 */
	private String breakSignNo ;
	/**
	 * 原渠道签约号
	 */
	private String oriChannelSignNo ;
	/**
	 * 原业务签约号
	 */
	private String oriSignNo ;
	public String getBreakSignNo() {
		return breakSignNo;
	}
	public void setBreakSignNo(String breakSignNo) {
		this.breakSignNo = breakSignNo;
	}
	public String getOriChannelSignNo() {
		return oriChannelSignNo;
	}
	public void setOriChannelSignNo(String oriChannelSignNo) {
		this.oriChannelSignNo = oriChannelSignNo;
	}
	public String getOriSignNo() {
		return oriSignNo;
	}
	public void setOriSignNo(String oriSignNo) {
		this.oriSignNo = oriSignNo;
	}
	
}
