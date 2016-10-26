package com.xpay.channel.front.channel.agentcollect.unionpay.msg;

import com.xpay.channel.front.dto.agentcollect.ACQueryPayRepFrontFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACQueryPayReqFrontFrontDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.util.DateUtil;
import com.xpay.channel.common.util.JsonUtil;
import com.xpay.channel.front.channel.agentcollect.unionpay.Unionpay_Config;
import com.xpay.channel.front.channel.agentcollect.unionpay.util.UnionpayUtil;
import com.xpay.channel.front.msg.impl.FreemarkChannelMsgHandlerImpl;
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
                                        FreemarkChannelMsgHandlerImpl<ACQueryPayReqFrontFrontDTO, ACQueryPayRepFrontFrontDTO> {
    @Override
    protected String getTemplatePath() {
        return null;
    }

    private static final Logger logger = LoggerFactory.getLogger(Unionpay_PayQueryMsgHandler.class);

    @Override
    public ACQueryPayReqFrontFrontDTO beforBuildMsg(ACQueryPayReqFrontFrontDTO req, ChannelConfig channelConfig)
                                                                                            throws BuildMsgException {
        try {
            req = super.beforBuildMsg(req, channelConfig);
            Unionpay_Config config = (Unionpay_Config) channelConfig;
            String charset = StringUtils.trim(config.getCharset());
            String encCerPath = StringUtils.trim(config.getEncCerPath());

            Map<String, String> data = new HashMap<String, String>();
            /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
            data.put("version", StringUtils.trim(config.getVersion()));
            data.put("encoding", StringUtils.trim(config.getCharset()));
            data.put("signMethod", StringUtils.trim(config.getSignMethod()));
            data.put("txnType", StringUtils.trim(config.getQueryTxnType()));
            data.put("txnSubType", StringUtils.trim(config.getDaikouTxnSubType()));
            data.put("bizType", StringUtils.trim(config.getDaikouBizType()));

            /***商户接入参数***/
            data.put("merId", channelConfig.getMerchantNo());
            data.put("accessType", StringUtils.trim(config.getAccessType()));

            data.put("orderId", req.getBankOrderNo());
            data.put("txnTime", DateUtil.DateToString(req.getPayOrderDT(), "yyyyMMddHHmmss"));

            /**对请求参数进行签名并发送http post请求，接收同步应答报文**/
            String pfxPath = channelConfig.getPfxPath();
            String pwd = channelConfig.getPfxPathPwd();
            String sign = UnionpayUtil.sign(data, charset, pfxPath, pwd);
            data.put("signature", sign);
            logger.info("#####[银联代扣结果查询] 请求参数map为:" + data);
            super.put("map", data);
        } catch (Exception e) {
            logger.error("#####[银联代扣结果查询] 拼装参数异常." + req.getBankOrderNo(), e);
            throw new BuildMsgException(EnumRtnResult.E030202);
        }
        return req;
    }

    @Override
    public byte[] builderMsg(ACQueryPayReqFrontFrontDTO req, ChannelConfig channelConfig)
                                                                               throws BuildMsgException {
        String charset = channelConfig.getCharset();
        Map<String, String> data = (Map<String, String>) super.get("map");
        String mapJson = JsonUtil.mapToStr(data);
        logger.info("[银联代扣结果查询] 传递参数为:" + mapJson);
        byte[] results = null;
        try {
            results = mapJson.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            logger.error("#####[银联代扣结果查询] 拼参时 参数转换错误." + req.getBankOrderNo(), e);
            throw new BuildMsgException(EnumRtnResult.E030202);
        }
        return results;
    }

    @Override
    public ACQueryPayRepFrontFrontDTO resolveMsg(ACQueryPayReqFrontFrontDTO req, byte[] rtnMsg,
                                                 ChannelConfig channelConfig) throws ResolveMsgException {
        ACQueryPayRepFrontFrontDTO repDTO = new ACQueryPayRepFrontFrontDTO();
        repDTO.setBankOrderNo(req.getBankOrderNo());
        repDTO.setPayStatus(EnumPayStatus.UNKNOW);
        if (rtnMsg == null || rtnMsg.length == 0) {
            throw new ResolveMsgException(EnumRtnResult.E030202);
        }

        try {
            String charset = StringUtils.trim(channelConfig.getCharset());
            String jsonMap = new String(rtnMsg, charset);
            logger.info("#####[银联代扣结果查询] 通信返回参数为:" + jsonMap);
            Map<String, String> respMap = JsonUtil.jsonTomMap(jsonMap);
            boolean signFlag = UnionpayUtil.verSign(respMap, channelConfig.getCerPath());
            logger.info("#####[银联代扣结果查询] 验证签名信息结果:" + signFlag);
            String respCode = respMap.get("respCode");
            String respMsg = respMap.get("respMsg");
            String bankNo = respMap.get("queryId");
            String oriRespCode = respMap.get("orazigRespCode");
            String oriRespMsg = respMap.get("origRespMsg");
            repDTO.setBankRtnCode(oriRespCode);
            repDTO.setBankRtnMsg(oriRespMsg);
            repDTO.setBankNo(bankNo);
            String txnAmount = respMap.get("txnAmt");
            if (StringUtils.isNotBlank(txnAmount)) {
                repDTO.setPayAmt(new BigDecimal(txnAmount));
            }
            String traceTime = respMap.get("traceTime");
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
