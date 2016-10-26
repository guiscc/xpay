package com.xpay.channel.front.channel.agentcollect.unionpay.msg;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.util.DateUtil;
import com.xpay.channel.common.util.JsonUtil;
import com.xpay.channel.front.channel.agentcollect.unionpay.Unionpay_Config;
import com.xpay.channel.front.channel.agentcollect.unionpay.util.UnionpayEncryptUtil;
import com.xpay.channel.front.channel.agentcollect.unionpay.util.UnionpayUtil;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthRepFrontFrontDTO;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthReqFrontFrontDTO;
import com.xpay.channel.front.msg.impl.FreemarkChannelMsgHandlerImpl;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.enums.EnumCardType;
import com.xpay.common.enums.EnumRtnResult;
import com.xpay.common.enums.EnumRtnStatus;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午1:39
 */
public class Unionpay_AuthMsgHandler
                                    extends
                                    FreemarkChannelMsgHandlerImpl<RealNameAuthReqFrontFrontDTO, RealNameAuthRepFrontFrontDTO> {
    @Override
    protected String getTemplatePath() {
        return null;
    }

    private static final Logger logger = LoggerFactory.getLogger(Unionpay_AuthMsgHandler.class);

    @Override
    public RealNameAuthReqFrontFrontDTO beforBuildMsg(RealNameAuthReqFrontFrontDTO req, ChannelConfig channelConfig)
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
            data.put("txnType", StringUtils.trim(config.getTxnType()));
            data.put("txnSubType", StringUtils.trim(config.getAuthSubTxnType()));
            data.put("bizType", StringUtils.trim(config.getDaikouBizType()));
            data.put("channelType", StringUtils.trim(config.getChannelType()));

            /***商户接入参数***/
            data.put("merId", channelConfig.getMerchantNo());
            data.put("accessType", StringUtils.trim(config.getAccessType()));
            data.put("orderId", req.getBankAuthrNo());
            data.put("txnTime", DateUtil.DateToString(req.getReqDateTime(), "yyyyMMddHHmmss"));
            data.put("accType", StringUtils.trim(config.getAccType()));

            Map<String, String> customerInfoMap = new HashMap<String, String>();
            customerInfoMap.put("certifTp", StringUtils.trim(config.getCertifTp()));
            customerInfoMap.put("certifId", req.getCerNo());
            customerInfoMap.put("customerNm", req.getHolderName());
            customerInfoMap.put("phoneNo", req.getMobileNo());
            if (EnumCardType.CREDIT.equals(req.getCardType())) {
                customerInfoMap.put("cvn2", req.getCvv2());
                customerInfoMap.put("expired", req.getExpireDate());
            }
            data.put("encryptCertId", UnionpayEncryptUtil.getCertId(encCerPath));
            String accNo = UnionpayEncryptUtil.encryptData(req.getCardNo(), charset, encCerPath);
            data.put("accNo", accNo);
            String customerInfoStr = UnionpayEncryptUtil.encryptData(customerInfoMap,
                req.getCardNo(), charset, encCerPath);
            data.put("customerInfo", customerInfoStr);
            /**对请求参数进行签名并发送http post请求，接收同步应答报文**/
            String pfxPath = channelConfig.getPfxPath();
            String pwd = channelConfig.getPfxPathPwd();
            String sign = UnionpayUtil.sign(data, charset, pfxPath, pwd);
            data.put("signature", sign);
            logger.info("#####[银联全渠道实名认证] 请求参数map为:" + data);
            super.put("map", data);
        } catch (Exception e) {
            logger.error("#####[银联全渠道实名认证] 拼装参数异常." + req.getBankAuthrNo(), e);
            throw new BuildMsgException(EnumRtnResult.E030201);
        }

        return req;
    }

    @Override
    public byte[] builderMsg(RealNameAuthReqFrontFrontDTO req, ChannelConfig channelConfig)
                                                                                 throws BuildMsgException {
        String charset = channelConfig.getCharset();
        Map<String, String> data = (Map<String, String>) super.get("map");
        String mapJson = JsonUtil.mapToStr(data);
        logger.info("[银联全渠道实名认证] 传递参数为:" + mapJson);
        byte[] results = null;
        try {
            results = mapJson.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            logger.error("#####[银联全渠道实名认证] 拼参时 参数转换错误." + req.getBankAuthrNo(), e);
            throw new BuildMsgException(EnumRtnResult.E030201);
        }
        return results;
    }

    @Override
    public RealNameAuthRepFrontFrontDTO resolveMsg(RealNameAuthReqFrontFrontDTO req, byte[] rtnMsg,
                                                   ChannelConfig channelConfig) throws ResolveMsgException {
        RealNameAuthRepFrontFrontDTO repDTO = new RealNameAuthRepFrontFrontDTO();
        if (rtnMsg == null || rtnMsg.length == 0) {
            throw new ResolveMsgException(EnumRtnResult.E030202);
        }

        try {
            String charset = StringUtils.trim(channelConfig.getCharset());
            String jsonMap = new String(rtnMsg, charset);
            logger.info("#####[银联全渠道实名认证] 通信返回参数为:" + jsonMap);
            Map<String, String> respMap = JsonUtil.jsonTomMap(jsonMap);
            boolean signFlag = UnionpayUtil.verSign(respMap, channelConfig.getCerPath());
            logger.info("#####[银联全渠道实名认证] 验证签名信息结果:" + signFlag);
            String respCode = respMap.get("respCode");
            String respMsg = respMap.get("respMsg");
            repDTO.setBankRtnCode(respCode);
            repDTO.setBankRtnMsg(respMsg);
            if ("00".equals(respCode)) {
                repDTO.setAuthStatus(EnumRtnStatus.SUCCESS);
            } else {
                repDTO.setAuthStatus(EnumRtnStatus.FAIL);
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("#####[银联全渠道实名认证] 解参时 参数转换错误.", e);
            throw new ResolveMsgException(EnumRtnResult.E030201);
        } catch (Exception e) {
            logger.error("#####[银联全渠道实名认证] 解参时 出现异常.", e);
            throw new ResolveMsgException(EnumRtnResult.E030201);
        }

        return repDTO;
    }
}
