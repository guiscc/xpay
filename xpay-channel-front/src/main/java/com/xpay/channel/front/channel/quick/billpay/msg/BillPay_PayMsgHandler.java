package com.xpay.channel.front.channel.quick.billpay.msg;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.xpay.channel.front.msg.impl.FreemarkChannelMsgHandlerImpl;
import com.xpay.common.utils.XMLUtils;
import org.dom4j.DocumentException;

import com.xpay.channel.common.dto.quick.PayConfirmRepDTO;
import com.xpay.channel.common.dto.quick.PayConfirmReqDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.util.DateUtil;
import com.xpay.channel.front.channel.quick.billpay.Billpay_Config;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Created by suxinxin on 16/2/16.
 */
public class BillPay_PayMsgHandler extends FreemarkChannelMsgHandlerImpl<PayConfirmReqDTO,PayConfirmRepDTO> {
    @Override
    protected String getTemplatePath() {
        return "/quick/billpay/pay.ftl";
    }
    
    @Override
    public PayConfirmReqDTO beforBuildMsg(PayConfirmReqDTO req, ChannelConfig channelConfig) throws BuildMsgException {
    	Billpay_Config billPay_config = (Billpay_Config)channelConfig;
        channelConfig.setPxfPath(req.getPfxPath());
        channelConfig.setPxfPass(req.getPfxPass());
        channelConfig.setBankURL(billPay_config.getPayUrl());
    	super.beforBuildMsg(req, channelConfig);
        super.put("version", billPay_config.getVersion());
        super.put("cardNo", req.getCardNo());
        super.put("amount", req.getAmount().setScale(2).toString());
        super.put("merchantNo", req.getMerchantNo());
        super.put("terminalId", billPay_config.getTerminalId());
        super.put("reqTime", DateUtil.DateStampToStringMs(req.getReqTime()));
        super.put("channelPayNo", req.getChannelPayNo());
        super.put("useId", req.getUserId());
        super.put("spFlag", billPay_config.getSpFlag());
        super.put("payBatch", billPay_config.getPayBatch());
        super.put("oriBankSignNo", req.getOriSignNo());
        return req;
    }
    
    @Override
    public PayConfirmRepDTO resolveMsg(PayConfirmReqDTO req, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
    	PayConfirmRepDTO repDTO = new PayConfirmRepDTO();
    	String rtnMsgStr;
		try {
			rtnMsgStr = new String(rtnMsg,channelConfig.getCharset());
			XMLUtils xmlUtils = new XMLUtils(rtnMsgStr);
			Map<String,String> map = new HashMap<String,String>();
			map.put("ns", "http://www.99bill.com/mas_cnp_merchant_interface");
			String errorCode = xmlUtils.getValueByXpath("//ns:MasMessage//ns:ErrorMsgContent//ns:errorCode", map);
			String errorMsg = xmlUtils.getValueByXpath("//ns:MasMessage//ns:ErrorMsgContent//ns:errorMessage", map);
			String bankRtnCode = xmlUtils.getValueByXpath("//ns:MasMessage//ns:TxnMsgContent//ns:responseCode", map);
			String bankRtnMsg = xmlUtils.getValueByXpath("//ns:MasMessage//ns:iTxnMsgContent//ns:responseTextMessage", map);
		}  catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
    	return null;
    }
}
