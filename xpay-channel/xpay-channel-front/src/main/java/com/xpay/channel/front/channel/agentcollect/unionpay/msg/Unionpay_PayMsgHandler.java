package com.xpay.channel.front.channel.agentcollect.unionpay.msg;

import com.xpay.channel.common.util.DateUtil;
import com.xpay.channel.front.channel.agentcollect.unionpay.util.UnionpayEncryptUtil;
import com.xpay.channel.front.channel.agentcollect.unionpay.util.UnionpayUtil;
import com.xpay.channel.front.dto.agentcollect.ACPayRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACPayReqFrontDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.channel.agentcollect.unionpay.Unionpay_Config;
import com.xpay.channel.front.msg.impl.FormChannelMsgHandlerImpl;
import com.xpay.channel.front.msg.model.MsgRepModel;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.enums.EnumCardType;
import com.xpay.common.enums.EnumPayStatus;
import com.xpay.common.enums.EnumRtnResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Remark 代扣
 * @Author pangyiyang
 * @Date 16/5/21 下午1:39
 */
public class Unionpay_PayMsgHandler extends
                                   FormChannelMsgHandlerImpl<ACPayReqFrontDTO, ACPayRepFrontDTO> {

    private static final Logger logger = LoggerFactory.getLogger(Unionpay_PayMsgHandler.class);

    @Override
    public ACPayReqFrontDTO beforBuildMsg(ACPayReqFrontDTO req, ChannelConfig channelConfig)
                                                                                  throws BuildMsgException {
        try {
            Unionpay_Config config = (Unionpay_Config) channelConfig;
            config.setBankURL(StringUtils.trim(config.getPayUrl()));

            Map<String, String> data = new HashMap();
            /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
            data.put("version", "5.0.0");
            data.put("encoding", "UTF-8");
            data.put("signMethod", "01");
            data.put("txnType", "11");
            data.put("txnSubType", "00");
            data.put("bizType", "000501");
            data.put("channelType", "07");

            /***商户接入参数***/
            data.put("merId", config.getMerchantNo());
            data.put("accessType", "0");
            data.put("orderId", req.getBankOrderNo());
            data.put("txnTime", DateUtil.DateToString(new Date(), "yyyyMMddHHmmss"));
            data.put("currencyCode", "156");
            data.put("txnAmt", String.valueOf(req.getPayAmt()));
            data.put("accType", "01");                              //账号类型

            String accNo = UnionpayUtil.encryptCardNo(req.getCardNo(), config);
            data.put("accNo", accNo);

            Map<String, String> customerInfoMap = new HashMap();
            customerInfoMap.put("certifTp", "01");
            customerInfoMap.put("certifId", req.getCertNo());
            customerInfoMap.put("customerNm", req.getHolderName());
            customerInfoMap.put("phoneNo", req.getMobileNo());
            if (EnumCardType.CREDIT.equals(req.getCardType())) {
                customerInfoMap.put("cvn2", req.getCvv2());
                customerInfoMap.put("expired", req.getExpiredDate());
            }
            data.put("encryptCertId", UnionpayUtil.getCertId(config,true));

            String customerInfoStr = UnionpayUtil.encryptData(customerInfoMap,
                req.getCardNo(), config);
            data.put("customerInfo",customerInfoStr);

            data.put("backUrl", StringUtils.trim(config.getNotifyUrl()));
            /**对请求参数进行签名并发送http post请求，接收同步应答报文**/
            String sign = UnionpayUtil.sign(data, config);
            data.put("signature", sign);
            req.setFormMap(data);
        } catch (Exception e) {
            logger.error("#####[银联代扣] 拼装参数异常." + req.getBankOrderNo(), e);
            throw new BuildMsgException(EnumRtnResult.E030201);
        }
        return req;
    }

    @Override
    public ACPayRepFrontDTO resolveMsg(ACPayReqFrontDTO req, MsgRepModel rtnMsg,
                                       ChannelConfig channelConfig) throws ResolveMsgException {
        ACPayRepFrontDTO repDTO = new ACPayRepFrontDTO();
        repDTO.setBankOrderNo(req.getBankOrderNo());
        repDTO.setPayAmt(repDTO.getPayAmt());
        repDTO.setPayStatus(EnumPayStatus.UNKNOW);
        if (StringUtils.isBlank(rtnMsg.getMsg())) {
            throw new ResolveMsgException(EnumRtnResult.E030202);
        }

        try {
            Map<String, String> respMap = UnionpayUtil.parseQString(rtnMsg.getMsg());
            boolean signFlag = UnionpayUtil.verSign(respMap, channelConfig.getCerPath());
            if (!signFlag) {
                throw new ResolveMsgException(EnumRtnResult.E030202);
            }
            String respCode = respMap.get("respCode") + "";
            String respMsg = respMap.get("respMsg") + "";
            String bankNo = respMap.get("queryId") + "";
            repDTO.setBankOrderNo(respCode);
            repDTO.setBankRtnMsg(respMsg);
            repDTO.setBankNo(bankNo);
            if ("00".equals(respCode)) {
                repDTO.setPayStatus(EnumPayStatus.SUCCESS);
            } else if ("03".equals(respCode) || "04".equals(respCode) || "05".equals(respCode)) {
                repDTO.setPayStatus(EnumPayStatus.FAIL);
            } else {
                repDTO.setPayStatus(EnumPayStatus.UNKNOW);
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("#####[银联代扣] 解参时 参数转换错误.", e);
            throw new ResolveMsgException(EnumRtnResult.E030202);
        } catch (Exception e) {
            logger.error("#####[银联代扣] 解参时 出现异常.", e);
            throw new ResolveMsgException(EnumRtnResult.E030202);
        }

        return repDTO;
    }
}
