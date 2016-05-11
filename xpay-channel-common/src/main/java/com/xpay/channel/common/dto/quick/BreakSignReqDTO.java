package com.xpay.channel.common.dto.quick;


/**
 * Created by suxinxin on 16/2/5.
 */
public class BreakSignReqDTO extends BaseQuickReqDTO {
	/**
     * 业务解约订单号
     */
    private String breakSignNo ;
    private String oriSignNo ;
    private String oriChannelSignNo ;

	public String getBreakSignNo() {
		return breakSignNo;
	}

	public void setBreakSignNo(String breakSignNo) {
		this.breakSignNo = breakSignNo;
	}

	public String getOriSignNo() {
		return oriSignNo;
	}

	public void setOriSignNo(String oriSignNo) {
		this.oriSignNo = oriSignNo;
	}

	public String getOriChannelSignNo() {
		return oriChannelSignNo;
	}

	public void setOriChannelSignNo(String oriChannelSignNo) {
		this.oriChannelSignNo = oriChannelSignNo;
	}
	

}
