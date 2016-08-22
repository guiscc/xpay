package com.xpay.channel.front.channel.quick.billpay.msg;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.xpay.channel.front.msg.impl.FreemarkChannelMsgHandlerImpl;
import org.dom4j.DocumentException;

import com.xpay.channel.common.dto.quick.SignConfirmRepDTO;
import com.xpay.channel.common.dto.quick.SignConfirmReqDTO;
import com.xpay.channel.common.dto.quick.SignRepDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.channel.quick.billpay.Billpay_Config;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.utils.XMLUtils;

/**
 * Created by suxinxin on 16/2/16.
 */
public class BillPay_SignConfirmMsgHandler extends FreemarkChannelMsgHandlerImpl<SignConfirmReqDTO,SignConfirmRepDTO> {

    @Override
    protected String getTemplatePath() {
        return "/quick/billpay/signConfirm.ftl";
    }
    
    @Override
    public SignConfirmReqDTO beforBuildMsg(SignConfirmReqDTO req, ChannelConfig channelConfig) throws BuildMsgException {
    	Billpay_Config billpay_config = (Billpay_Config) channelConfig;
        channelConfig.setPxfPath(req.getPfxPath());
        channelConfig.setPxfPass(req.getPfxPass());
        channelConfig.setBankURL(billpay_config.getSignConfirmUrl());
        super.beforBuildMsg(req, channelConfig);
        super.put("version", billpay_config.getVersion());
        super.put("merchantNo", req.getMerchantNo());
        super.put("userId", req.getUserId());
        super.put("orderNo", req.getOrderNo());
        super.put("cardNo", req.getCardNo());
        super.put("mobileNo", req.getMobileNo());
        super.put("vaildCode", req.getVaildCode());
        super.put("token", req.getToken());
        return req;
    }
    
    @Override
    public SignConfirmRepDTO resolveMsg(SignConfirmReqDTO req, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
    	SignRepDTO signRepDTO = new SignRepDTO();
    	
    	try {
			String rtnMsgStr = new String(rtnMsg,channelConfig.getCharset());
			XMLUtils xmlUtils = new XMLUtils(rtnMsgStr);
			Map<String,String> map = new HashMap<String,String>();
			map.put("ns", "http://www.99bill.com/mas_cnp_merchant_interface");
			String errorCode = xmlUtils.getValueByXpath("//ns:MasMessage//ns:ErrorMsgContent//ns:errorCode", map);
			String errorMsg = xmlUtils.getValueByXpath("//ns:MasMessage//ns:ErrorMsgContent//ns:errorMessage", map);
			String orderNo = xmlUtils.getValueByXpath("//ns:MasMessage//ns:indAuthDynVerifyContent//ns:externalRefNumber", map);
			String bankRtnCode = xmlUtils.getValueByXpath("//ns:MasMessage//ns:indAuthDynVerifyContent//ns:responseCode", map);
			String bankRtnMsg = xmlUtils.getValueByXpath("//ns:MasMessage//ns:indAuthDynVerifyContent//ns:responseTextMessage", map);
			String userId = xmlUtils.getValueByXpath("//ns:MasMessage//ns:indAuthDynVerifyContent//ns:customerId", map);
			String storablePan = xmlUtils.getValueByXpath("//ns:MasMessage//ns:indAuthDynVerifyContent//ns:storablePan", map);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
}
