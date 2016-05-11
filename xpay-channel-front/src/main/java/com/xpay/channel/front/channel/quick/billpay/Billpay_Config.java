package com.xpay.channel.front.channel.quick.billpay;

import com.xpay.channel.front.utils.ChannelConfig;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by suxinxin on 16/2/16.
 */
public class Billpay_Config extends ChannelConfig {

    /**
     * 终端id
     */
    private String terminalId;

    /**
     * 签约地址
     */
    private String signUrl;

    /**
     * 签约确认地址
     */
    private String signConfirmUrl;

    /**
     * 支付地址
     */
    private String payUrl;

    /**
     * 支付查询地址
     */
    private String queryPayUrl;
    
    /**
     * 版本号
     */
    private String version;
    
    /**
     * 特殊交易标志
     */
    private String spFlag;
    
    /**
     * 快捷支付批次
     * 1：首次支付 2：再次支付
     */
    private String payBatch;

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl;
    }

    public String getSignConfirmUrl() {
        return signConfirmUrl;
    }

    public void setSignConfirmUrl(String signConfirmUrl) {
        this.signConfirmUrl = signConfirmUrl;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getQueryPayUrl() {
        return queryPayUrl;
    }

    public void setQueryPayUrl(String queryPayUrl) {
        this.queryPayUrl = queryPayUrl;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSpFlag() {
		return spFlag;
	}

	public void setSpFlag(String spFlag) {
		this.spFlag = spFlag;
	}

	public String getPayBatch() {
		return payBatch;
	}

	public void setPayBatch(String payBatch) {
		this.payBatch = payBatch;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
