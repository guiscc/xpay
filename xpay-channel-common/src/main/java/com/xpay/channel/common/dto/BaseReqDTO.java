package com.xpay.channel.common.dto;

import com.xpay.channel.common.model.ChannelRemark;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by suxinxin on 16/2/5.
 */
public class BaseReqDTO {
    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 证书路径
     */
    private String pfxPath;

    /**
     * 证书密码
     */
    private String pfxPass;
    
    /**
     * 请求时间
     */
    private Date reqTime ;
    
    /**
     * 接口编码
     */
    private String interCode ;
    
    /**
     * 通道编码
     */
    private String channelCode ;
    
    /**
     * 备注字段
     */
    private Map<String , String> map = new HashMap<String, String>() ;
    
    /**
     * http 请求报文头
     */
    private Map<String, String> headMap ;
    
    private ChannelRemark channelRemark ;

    public String getMerchantNo() {
        return merchantNo;
    }

    public String getPfxPath() {
        return pfxPath;
    }

    public void setPfxPath(String pfxPath) {
        this.pfxPath = pfxPath;
    }

    public String getPfxPass() {
        return pfxPass;
    }

    public void setPfxPass(String pfxPass) {
        this.pfxPass = pfxPass;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Map<String, String> getHeadMap() {
        return headMap;
    }

    public void setHeadMap(Map<String, String> headMap) {
        this.headMap = headMap;
    }
    
    public Date getReqTime() {
		return reqTime;
	}

	public void setReqTime(Date reqTime) {
		this.reqTime = reqTime;
	}

	public ChannelRemark getChannelRemark() {
		return channelRemark;
	}

	public void setChannelRemark(ChannelRemark channelRemark) {
		this.channelRemark = channelRemark;
	}

	public String getInterCode() {
		return interCode;
	}

	public void setInterCode(String interCode) {
		this.interCode = interCode;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	@Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this) ;
    }
}
