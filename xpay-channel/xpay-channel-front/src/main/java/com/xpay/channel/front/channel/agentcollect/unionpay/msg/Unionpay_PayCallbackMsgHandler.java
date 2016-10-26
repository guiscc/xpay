package com.xpay.channel.front.channel.agentcollect.unionpay.msg;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.util.DateUtil;
import com.xpay.channel.common.util.JsonUtil;
import com.xpay.channel.front.channel.agentcollect.unionpay.util.UnionpayUtil;
import com.xpay.channel.front.dto.agentcollect.PayCallbackRepFrontFrontDTO;
import com.xpay.channel.front.dto.agentcollect.PayCallbackReqFrontFrontDTO;
import com.xpay.channel.front.msg.impl.FreemarkChannelMsgHandlerImpl;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.enums.EnumPayStatus;
import com.xpay.common.enums.EnumRtnResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/28 下午3:00
 */
public class Unionpay_PayCallbackMsgHandler
                                           extends
                                           FreemarkChannelMsgHandlerImpl<PayCallbackReqFrontFrontDTO, PayCallbackRepFrontFrontDTO> {

    @Override
    protected String getTemplatePath() {
        return null;
    }

    private static final Logger logger = LoggerFactory
                                           .getLogger(Unionpay_PayCallbackMsgHandler.class);

    @Override
    public byte[] builderMsg(PayCallbackReqFrontFrontDTO t, ChannelConfig channelConfig)
                                                                              throws BuildMsgException {
        return "".getBytes();
    }

    @Override
    public PayCallbackRepFrontFrontDTO resolveMsg(PayCallbackReqFrontFrontDTO reqDTO, byte[] rtnMsg,
                                                  ChannelConfig channelConfig) throws ResolveMsgException {
        PayCallbackRepFrontFrontDTO repDTO = new PayCallbackRepFrontFrontDTO();
        try {
            logger.info("#####[银联全渠道代扣] 异步回调 处理开始.");
            String jsonMap = new String(rtnMsg, channelConfig.getCharset());
            logger.info("#####[银联代扣] 通信返回参数为:" + jsonMap);
            Map<String, String> respMap = JsonUtil.jsonTomMap(jsonMap);
            logger.info("#####[[银联全渠道代扣] 异步回调 返回Map为:" + respMap);
            if (respMap == null || respMap.isEmpty()) {
                logger.info("#####[银联全渠道代扣] 异步回调 获取的返回报文为空.");
                throw new ResolveMsgException(EnumRtnResult.E030202);
            }

            boolean flag = UnionpayUtil.verSign(respMap, channelConfig.getCerPath());
            if (flag) {
                //拼装报文,并返回结果
                logger.info("#####[银联全渠道代扣] 异步回调 验签成功:flag=" + flag);
                String respCode = respMap.get("respCode");
                String respMsg = respMap.get("respMsg");
                repDTO.setBankRtnCode(respCode);
                repDTO.setBankRtnMsg(respMsg);

                if ("00".equals(respCode)) {
                    repDTO.setPayStatus(EnumPayStatus.SUCCESS);

                    String traceTime = respMap.get("tradeTime");
                    String orderId = respMap.get("orderId");
                    String txnAmt = respMap.get("txnAmt");
                    String queryId = respMap.get("queryId");
                    repDTO.setPayStatus(EnumPayStatus.SUCCESS);
                    repDTO.setBankOrderNo(orderId);
                    repDTO.setBankNo(queryId);
                    if (StringUtils.isNotBlank(txnAmt)) {
                        repDTO.setPayAmt(new BigDecimal(txnAmt));
                    }
                    Date bankFinishTime = null;
                    if (StringUtils.isNotBlank(traceTime)) {
                        String yyyy = DateUtil.DateToString(new Date(), "yyyy");
                        bankFinishTime = DateUtil.StringToDate(yyyy + traceTime, "yyyyMMddHHmmss");
                    }
                    repDTO.setBankFinishDT(bankFinishTime);

                } else if ("03".equals(respCode) || "04".equals(respCode) || "05".equals(respCode)) {
                    repDTO.setPayStatus(EnumPayStatus.UNKNOW);
                } else {
                    repDTO.setPayStatus(EnumPayStatus.UNKNOW);
                }
            } else {
                logger.info("#####[银联全渠道代扣] 回调验签失败:flag=" + flag);
                repDTO.setPayStatus(EnumPayStatus.UNKNOW);
                repDTO.setBankRtnMsg("验签失败");
                repDTO.setBankRtnCode(EnumPayStatus.UNKNOW.name());
            }
        } catch (Exception e) {
            logger.info("#####[银联全渠道代扣] 解析报文异常.", e);
            throw new ResolveMsgException(EnumRtnResult.E030202);
        }

        return repDTO;
    }

    public static void main(String[] args) {
        System.err.println(DateUtil.StringToDate("1212121212", "MMddHHmmss"));
    }
}
