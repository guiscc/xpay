package com.xpay.channel.front.channel.agentcollect.unionpay.msg;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.util.DateUtil;
import com.xpay.channel.common.util.JsonUtil;
import com.xpay.channel.front.channel.agentcollect.unionpay.Unionpay_Config;
import com.xpay.channel.front.channel.agentcollect.unionpay.util.UnionpayUtil;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthReqFrontDTO;
import com.xpay.channel.front.msg.impl.FmkChannelMsgHandlerImpl;
import com.xpay.channel.front.msg.impl.FormChannelMsgHandlerImpl;
import com.xpay.channel.front.msg.model.MsgRepModel;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.enums.EnumCardType;
import com.xpay.common.enums.EnumRtnResult;
import com.xpay.common.enums.EnumRtnStatus;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午1:39
 */
public class Unionpay_AuthMsgHandler
                                    extends
                                    FormChannelMsgHandlerImpl<RealNameAuthReqFrontDTO, RealNameAuthRepFrontDTO> {

    private static final Logger logger = LoggerFactory.getLogger(Unionpay_AuthMsgHandler.class);

    @Override
    public RealNameAuthReqFrontDTO beforBuildMsg(RealNameAuthReqFrontDTO req,
                                                 ChannelConfig channelConfig)
                                                                             throws BuildMsgException {
        try {
            req = super.beforBuildMsg(req, channelConfig);
            Unionpay_Config config = (Unionpay_Config) channelConfig;
            config.setBankURL(config.getAuthUrl());

            Map<String, String> data = new HashMap();
            /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
            data.put("version", "5.0.0");
            data.put("encoding", config.getCharset());
            data.put("signMethod", "01");
            data.put("txnType", "72");
            data.put("txnSubType", "01");
            data.put("bizType", "000501");
            data.put("channelType", "07");

            /***商户接入参数***/
            data.put("merId", channelConfig.getMerchantNo());
            data.put("accessType", "0");
            data.put("orderId", req.getBankAuthrNo());
            data.put("txnTime", DateUtil.DateToString(new Date(), "yyyyMMddHHmmss"));

            String accNo = UnionpayUtil.encryptCardNo(req.getCardNo(), config);
            data.put("accNo", accNo);

            Map<String, String> customerInfoMap = new HashMap();
            customerInfoMap.put("certifTp", "01");
            customerInfoMap.put("certifId", req.getCertNo());
            customerInfoMap.put("customerNm", req.getHolderName());
            customerInfoMap.put("phoneNo", req.getMobileNo());
            if (EnumCardType.CREDIT.equals(req.getCardType())) {
                customerInfoMap.put("cvn2", req.getCvv2());
                customerInfoMap.put("expired", req.getExpireDate());
            }
            data.put("encryptCertId", UnionpayUtil.getCertId(config, true));

            String customerInfoStr = UnionpayUtil.encryptData(customerInfoMap, req.getCardNo(),
                config);
            data.put("customerInfo", customerInfoStr);

            String sign = UnionpayUtil.sign(data, config);
            data.put("signature", sign);
            req.setFormMap(data);
        } catch (Exception e) {
            logger.error("#####[银联全渠道实名认证] 拼装参数异常." + req.getBankAuthrNo(), e);
            throw new BuildMsgException(EnumRtnResult.E030201);
        }

        return req;
    }

    @Override
    public RealNameAuthRepFrontDTO resolveMsg(RealNameAuthReqFrontDTO req, MsgRepModel rtnMsg,
                                              ChannelConfig channelConfig)
                                                                          throws ResolveMsgException {
        RealNameAuthRepFrontDTO repDTO = new RealNameAuthRepFrontDTO();
        if (StringUtils.isBlank(rtnMsg.getMsg())) {
            throw new ResolveMsgException(EnumRtnResult.E030202);
        }

        try {
            Map<String, String> respMap = UnionpayUtil.parseQString(rtnMsg.getMsg());
            boolean signFlag = UnionpayUtil.verSign(respMap, channelConfig.getCerPath());
            logger.info("#####[银联全渠道实名认证] 验证签名信息结果:" + signFlag);
            String respCode = respMap.get("respCode") + "";
            String respMsg = respMap.get("respMsg") + "";
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
