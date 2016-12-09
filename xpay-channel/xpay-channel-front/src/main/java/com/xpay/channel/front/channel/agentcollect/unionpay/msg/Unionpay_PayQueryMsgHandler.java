package com.xpay.channel.front.channel.agentcollect.unionpay.msg;

import com.xpay.channel.front.channel.agentcollect.unionpay.util.UnionpayUtil;
import com.xpay.channel.front.dto.agentcollect.ACQueryPayRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACQueryPayReqFrontDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.util.DateUtil;
import com.xpay.channel.front.channel.agentcollect.unionpay.Unionpay_Config;
import com.xpay.channel.front.msg.impl.FormChannelMsgHandlerImpl;
import com.xpay.channel.front.msg.model.MsgRepModel;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.enums.EnumPayStatus;
import com.xpay.common.enums.EnumRtnResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Remark 代扣
 * @Author pangyiyang
 * @Date 16/5/21 下午1:39
 */
public class Unionpay_PayQueryMsgHandler
                                        extends
        FormChannelMsgHandlerImpl<ACQueryPayReqFrontDTO, ACQueryPayRepFrontDTO> {

    private static final Logger logger = LoggerFactory.getLogger(Unionpay_PayQueryMsgHandler.class);

    @Override
    public ACQueryPayReqFrontDTO beforBuildMsg(ACQueryPayReqFrontDTO req, ChannelConfig channelConfig) throws BuildMsgException {
        try {
            Unionpay_Config config = (Unionpay_Config) channelConfig;

            Map<String, String> data = new HashMap<>();
            /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
            data.put("version", "5.0.0");
            data.put("encoding", config.getCharset());
            data.put("signMethod", "01");
            data.put("txnType", "00");
            data.put("txnSubType", "00");
            data.put("bizType", "000501");

            /***商户接入参数***/
            data.put("merId", channelConfig.getMerchantNo());
            data.put("accessType", "0");

            data.put("orderId", req.getBankOrderNo());
            data.put("txnTime", DateUtil.DateToString(req.getPayOrderDT(), "yyyyMMddHHmmss"));

            config.setBankURL(config.getPayQueryUrl());
            String digest = UnionpayUtil.sign(data, config);
            data.put("signature", digest);
            req.setFormMap(data);
            return req;
        } catch (Exception e) {
            logger.error("组建报文错误",e);
            throw new BuildMsgException(EnumRtnResult.E000000);
        }
    }

    @Override
    public ACQueryPayRepFrontDTO resolveMsg(ACQueryPayReqFrontDTO req, MsgRepModel rtnMsg,
                                            ChannelConfig channelConfig) throws ResolveMsgException {
        ACQueryPayRepFrontDTO repDTO = new ACQueryPayRepFrontDTO();
        repDTO.setBankOrderNo(req.getBankOrderNo());
        repDTO.setPayStatus(EnumPayStatus.UNKNOW);
        if (rtnMsg == null || StringUtils.isBlank(rtnMsg.getMsg())) {
            throw new ResolveMsgException(EnumRtnResult.E030202);
        }

        try {
            Map<String,String> respMap = UnionpayUtil.parseQString(rtnMsg.getMsg());
            boolean signFlag = UnionpayUtil.verSign(respMap, channelConfig.getCerPath());
            if(!signFlag){
                throw new ResolveMsgException(EnumRtnResult.E030202);
            }
            String respCode = respMap.get("respCode")+"";
            String respMsg = respMap.get("respMsg")+"";
            String bankNo = respMap.get("queryId")+"";
            String oriRespCode = respMap.get("origRespCode")+"";
            String oriRespMsg = respMap.get("origRespMsg")+"";
            repDTO.setBankRtnCode(oriRespCode);
            repDTO.setBankRtnMsg(oriRespMsg);
            repDTO.setBankNo(bankNo);
            String txnAmount = respMap.get("txnAmt");
            if (StringUtils.isNotBlank(txnAmount)) {
                repDTO.setPayAmt(new BigDecimal(txnAmount));
            }
            String traceTime = respMap.get("traceTime")+"";
            if (StringUtils.isNotBlank(traceTime)) {
                repDTO.setBankFinishTime(DateUtil.StringToDate(traceTime, "MMddHHmmss"));
            } else {
                repDTO.setBankFinishTime(new Date());
            }
            if ("00".equals(respCode) && "00".equals(oriRespCode)) {
                repDTO.setPayStatus(EnumPayStatus.SUCCESS);
            } else if ("03".equals(respCode) || "04".equals(respCode) || "05".equals(respCode)) {
                repDTO.setPayStatus(EnumPayStatus.UNKNOW);
            } else {
                repDTO.setPayStatus(EnumPayStatus.FAIL);
                repDTO.setBankRtnMsg(respMsg);
                repDTO.setBankRtnCode(respCode);
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("#####[银联代扣结果查询] 解参时 参数转换错误.", e);
            throw new ResolveMsgException(EnumRtnResult.E030202);
        } catch (Exception e) {
            logger.error("#####[银联代扣结果查询] 解参时 出现异常.", e);
            throw new ResolveMsgException(EnumRtnResult.E030202);
        }

        return repDTO;
    }
}
