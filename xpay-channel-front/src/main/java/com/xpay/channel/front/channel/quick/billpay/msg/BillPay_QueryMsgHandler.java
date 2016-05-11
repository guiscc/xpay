package com.xpay.channel.front.channel.quick.billpay.msg;

import com.xpay.channel.common.dto.quick.PayQueryRepDTO;
import com.xpay.channel.common.dto.quick.PayQueryReqDTO;
import com.xpay.channel.common.enums.EnumSysRtnCode;
import com.xpay.channel.common.enums.EnumTradeStatus;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.channel.quick.billpay.Billpay_Config;
import com.xpay.channel.front.msg.impl.FreemarkChannelMsgHandlerImpl;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.utils.XMLUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by suxinxin on 16/2/16.
 */
public class BillPay_QueryMsgHandler extends FreemarkChannelMsgHandlerImpl<PayQueryReqDTO, PayQueryRepDTO> {

    private static final Logger logger = LoggerFactory.getLogger(BillPay_QueryMsgHandler.class);

    @Override
    protected String getTemplatePath() {
        return "/quick/billpay/queryPay.ftl";
    }

    @Override
    public PayQueryReqDTO beforBuildMsg(PayQueryReqDTO queryPayReqDTO, ChannelConfig channelConfig) throws BuildMsgException {
        Billpay_Config billpay_config = (Billpay_Config) channelConfig;
        channelConfig.setPxfPath(queryPayReqDTO.getPfxPath());
        channelConfig.setPxfPass(queryPayReqDTO.getPfxPass());
        channelConfig.setBankURL(billpay_config.getQueryPayUrl());
        return super.beforBuildMsg(queryPayReqDTO, channelConfig);
    }

    @Override
    public PayQueryRepDTO resolveMsg(PayQueryReqDTO queryPayReqDTO, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
        PayQueryRepDTO queryPayRepDTO = new PayQueryRepDTO();
        try {

            String rtnMsgStr = new String(rtnMsg, channelConfig.getCharset());
            XMLUtils xmlUtils = new XMLUtils(rtnMsgStr);
            Map<String, String> map = new HashMap<String, String>();
            map.put("ns", "http://www.99bill.com/mas_cnp_merchant_interface");
            String bankRtnCode = xmlUtils.getValueByXpath("//ns:MasMessage//ns:TxnMsgContent//ns:responseCode", map);  //返回码
            String bankRtnMsg = xmlUtils.getValueByXpath("//ns:MasMessage//ns:TxnMsgContent//ns:responseTextMessage", map); //返回信息
            String payOrderNo = xmlUtils.getValueByXpath("//ns:MasMessage//ns:TxnMsgContent//ns:externalRefNumber", map); //支付单号
            String tradeState = xmlUtils.getValueByXpath("//ns:MasMessage//ns:TxnMsgContent//ns:txnStatus", map); //交易状态
            if (StringUtils.isBlank(payOrderNo)) {
                payOrderNo = queryPayReqDTO.getOriChannelPayNo();
            }
            String amountTmp = xmlUtils.getValueByXpath("//ns:MasMessage//ns:TxnMsgContent//ns:amount",map);
            BigDecimal amount = new BigDecimal(0);
            if (!StringUtils.isBlank(amountTmp)) {
                amount = new BigDecimal(amountTmp); //金额
            }


            if ("00".equals(bankRtnCode)) {
                if (queryPayReqDTO.getOriChannelPayNo().equals(payOrderNo)) {
                    if ("S".equals(tradeState)) {
                        queryPayRepDTO.setTradeStatus(EnumTradeStatus.SUCCESS);
                    } else {
                        queryPayRepDTO.setTradeStatus(EnumTradeStatus.UNKNOW);
                    }
                }
            } else {
                queryPayRepDTO.setTradeStatus(EnumTradeStatus.FAIL);
            }

            queryPayRepDTO.setAmount(amount);
            queryPayRepDTO.setOriChannelPayNo(payOrderNo); //支付单号
            queryPayRepDTO.setRtnCode(bankRtnCode);
            queryPayRepDTO.setRtnMsg(bankRtnMsg);

            return queryPayRepDTO;
        } catch (UnsupportedEncodingException e) {
            logger.error("[渠道系统][前置模块]报文根据编码转换失败", e);
            throw new ResolveMsgException(EnumSysRtnCode.R0000, EnumTradeStatus.FAIL);
        } catch (DocumentException e) {
            logger.error("[渠道系统][前置模块]报文解析xml失败", e);
            throw new ResolveMsgException(EnumSysRtnCode.R0000, EnumTradeStatus.FAIL);
        }

    }
}
