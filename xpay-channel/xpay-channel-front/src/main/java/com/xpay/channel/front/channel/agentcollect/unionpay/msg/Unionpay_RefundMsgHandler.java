package com.xpay.channel.front.channel.agentcollect.unionpay.msg;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.util.DateUtil;
import com.xpay.channel.common.util.JsonUtil;
import com.xpay.channel.front.channel.agentcollect.unionpay.Unionpay_Config;
import com.xpay.channel.front.channel.agentcollect.unionpay.util.UnionpayUtil;
import com.xpay.channel.front.dto.agentcollect.RefundRepFrontFrontDTO;
import com.xpay.channel.front.dto.agentcollect.RefundReqFrontFrontDTO;
import com.xpay.channel.front.msg.impl.FreemarkChannelMsgHandlerImpl;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.enums.EnumRefundStatus;
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
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/23 下午8:10
 */
public class Unionpay_RefundMsgHandler extends
                                      FreemarkChannelMsgHandlerImpl<RefundReqFrontFrontDTO, RefundRepFrontFrontDTO> {
    @Override
    protected String getTemplatePath() {
        return null;
    }

    private static final Logger logger = LoggerFactory.getLogger(Unionpay_RefundMsgHandler.class);

    @Override
    public RefundReqFrontFrontDTO beforBuildMsg(RefundReqFrontFrontDTO req, ChannelConfig channelConfig)
                                                                                    throws BuildMsgException {
        try {
            req = super.beforBuildMsg(req, channelConfig);
            Unionpay_Config config = (Unionpay_Config) channelConfig;
            //            req.setBankUrl(StringUtils.trim(config.getQueryUrl()));
            String charset = StringUtils.trim(config.getCharset());
            String encCerPath = StringUtils.trim(config.getEncCerPath());

            Map<String, String> data = new HashMap<String, String>();
            /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
            data.put("version", StringUtils.trim(config.getVersion()));
            data.put("encoding", StringUtils.trim(config.getCharset()));
            data.put("signMethod", StringUtils.trim(config.getSignMethod()));
            data.put("txnType", StringUtils.trim(config.getRefundTxnType()));
            data.put("txnSubType", StringUtils.trim(config.getDaikouTxnSubType()));
            data.put("bizType", StringUtils.trim(config.getDaikouBizType()));
            data.put("channelType", StringUtils.trim(config.getChannelType()));

            /***商户接入参数***/
            data.put("merId", channelConfig.getMerchantNo());
            data.put("accessType", StringUtils.trim(config.getAccessType()));
            data.put("orderId", req.getBankRefundNo());
            data.put("txnTime", DateUtil.DateToString(req.getPayDateTime(), "yyyyMMddHHmmss"));
            data.put("currencyCode", StringUtils.trim(config.getDaikouCurrencyCode()));
            data.put("txnAmt", String.valueOf(req.getRefundAmt()));
            data.put("backUrl", StringUtils.trim(config.getNotifyUrl()));
            data.put("origQryId", req.getBankOrderNo());

            /**对请求参数进行签名并发送http post请求，接收同步应答报文**/
            String pfxPath = channelConfig.getPfxPath();
            String pwd = channelConfig.getPfxPathPwd();
            String sign = UnionpayUtil.sign(data, charset, pfxPath, pwd);
            data.put("signature", sign);
            logger.info("#####[银联代扣退货] 请求参数map为:" + data);
            super.put("map", data);
        } catch (Exception e) {
            logger.error("#####[银联代扣退货] 拼装参数异常." + req.getBankRefundNo(), e);
            throw new BuildMsgException(EnumRtnResult.E030202);
        }
        return req;
    }

    @Override
    public byte[] builderMsg(RefundReqFrontFrontDTO req, ChannelConfig channelConfig)
                                                                           throws BuildMsgException {
        String charset = channelConfig.getCharset();
        Map<String, String> data = (Map<String, String>) super.get("map");
        String mapJson = JsonUtil.mapToStr(data);
        logger.info("[银联代扣退货] 传递参数为:" + mapJson);
        byte[] results = null;
        try {
            results = mapJson.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            logger.error("#####[银联代扣退货] 拼参时 参数转换错误." + req.getBankRefundNo(), e);
            throw new BuildMsgException(EnumRtnResult.E030202);
        }
        return results;
    }

    @Override
    public RefundRepFrontFrontDTO resolveMsg(RefundReqFrontFrontDTO req, byte[] rtnMsg, ChannelConfig channelConfig)
                                                                                                throws ResolveMsgException {
        RefundRepFrontFrontDTO repDTO = new RefundRepFrontFrontDTO();
        repDTO.setBankOrderNo(req.getBankOrderNo());
        repDTO.setRefundAmt(repDTO.getRefundAmt());
        if (rtnMsg == null || rtnMsg.length == 0) {
            throw new ResolveMsgException(EnumRtnResult.E030202);
        }

        try {
            String charset = StringUtils.trim(channelConfig.getCharset());
            String jsonMap = new String(rtnMsg, charset);
            logger.info("#####[银联代扣退货] 通信返回参数为:" + jsonMap);
            Map<String, String> respMap = JsonUtil.jsonTomMap(jsonMap);
            boolean signFlag = UnionpayUtil.verSign(respMap, channelConfig.getCerPath());
            logger.info("#####[银联代扣退货] 验证签名信息结果:" + signFlag);
            String respCode = respMap.get("respCode");
            String respMsg = respMap.get("respMsg");
            String bankNo = respMap.get("queryId");
            repDTO.setBankRtnCode(respCode);
            repDTO.setBankRtnMsg(respMsg);
            repDTO.setBankOrderNo(bankNo);
            repDTO.setBankRefundNo(req.getBankRefundNo());
            String txnAmount = respMap.get("txnAmt");

            logger.info("txnAmount=" + txnAmount);
            if (StringUtils.isNotBlank(txnAmount) && !"null".equals(txnAmount)) {
                repDTO.setRefundAmt(new BigDecimal(txnAmount));
            }
            String traceTime = respMap.get("traceTime");
            if (StringUtils.isNotBlank(traceTime)) {
                repDTO.setBankFinishTime(DateUtil.StringToDate(traceTime, "MMddHHmmss"));
            } else {
                repDTO.setBankFinishTime(new Date());
            }
            if ("00".equals(respCode)) {
                repDTO.setRefundStatus(EnumRefundStatus.PROCESS);
            } else if ("03".equals(respCode) || "04".equals(respCode) || "05".equals(respCode)) {
                repDTO.setRefundStatus(EnumRefundStatus.UNKNOW);
            } else {
                repDTO.setRefundStatus(EnumRefundStatus.UNKNOW);
            }
            repDTO.setBankOrderNo(req.getBankOrderNo());
            repDTO.setRefundAmt(req.getRefundAmt());
        } catch (UnsupportedEncodingException e) {
            logger.error("#####[银联代扣退货] 解参时 参数转换错误.", e);
            throw new ResolveMsgException(EnumRtnResult.E030202);
        } catch (Exception e) {
            logger.error("#####[银联代扣退货] 解参时 出现异常.", e);
            throw new ResolveMsgException(EnumRtnResult.E030202);
        }

        return repDTO;
    }
}
