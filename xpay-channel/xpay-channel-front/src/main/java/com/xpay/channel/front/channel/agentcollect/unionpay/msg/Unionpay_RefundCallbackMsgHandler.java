//package com.xpay.channel.front.channel.agentcollect.unionpay.msg;
//
//import com.xpay.channel.common.exception.BuildMsgException;
//import com.xpay.channel.common.exception.ResolveMsgException;
//import com.xpay.channel.common.util.DateUtil;
//import com.xpay.channel.common.util.JsonUtil;
//import com.xpay.channel.front.channel.agentcollect.unionpay.util.UnionpayUtil;
//import com.xpay.channel.front.dto.agentcollect.RefundCallbackRepFrontDTO;
//import com.xpay.channel.front.dto.agentcollect.RefundCallbackReqFrontDTO;
//import com.xpay.channel.front.msg.impl.FmkChannelMsgHandlerImpl;
//import com.xpay.channel.front.utils.ChannelConfig;
//import com.xpay.common.enums.EnumRefundStatus;
//import com.xpay.common.enums.EnumRtnResult;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.math.BigDecimal;
//import java.util.Date;
//import java.util.Map;
//
///**
// * @Remark see class name
// * @Author pangyiyang
// * @Date 16/5/28 下午3:00
// */
//public class Unionpay_RefundCallbackMsgHandler
//                                              extends
//                                              FmkChannelMsgHandlerImpl<RefundCallbackReqFrontDTO, RefundCallbackRepFrontDTO> {
//
//    @Override
//    protected String getTemplatePath() {
//        return null;
//    }
//
//    private static final Logger logger = LoggerFactory
//                                           .getLogger(Unionpay_RefundCallbackMsgHandler.class);
//
//    @Override
//    public byte[] builderMsg(RefundCallbackReqFrontDTO t, ChannelConfig channelConfig)
//                                                                                 throws BuildMsgException {
//        return "".getBytes();
//    }
//
//    @Override
//    public RefundCallbackRepFrontDTO resolveMsg(RefundCallbackReqFrontDTO reqDTO, byte[] rtnMsg,
//                                                ChannelConfig channelConfig) throws ResolveMsgException {
//        RefundCallbackRepFrontDTO repDTO = new RefundCallbackRepFrontDTO();
//        try {
//            logger.info("#####[银联全渠道代扣退款] 异步回调 处理开始.");
//            if (rtnMsg == null || rtnMsg.length == 0) {
//                throw new ResolveMsgException(EnumRtnResult.E030202);
//            }
//
//            String charset = StringUtils.trim(channelConfig.getCharset());
//            String jsonMap = new String(rtnMsg, charset);
//
//            Map<String, Object> respMap = JsonUtil.jsonTomMap(jsonMap);
//            boolean signFlag = UnionpayUtil.verSign(respMap, channelConfig.getCerPath());
//
//            logger.info("#####[[银联全渠道代扣退款] 异步回调 返回Map为:" + map);
//            if (respMap == null) {
//                logger.info("#####[银联全渠道代扣退款] 异步回调 获取的返回报文为空.");
//                throw new ResolveMsgException(EnumRtnResult.E030202);
//            }
//            boolean flag = UnionpayUtil.verSign(respMap, channelConfig.getCerPath());
//            if (flag) {
//                //拼装报文,并返回结果
//                logger.info("#####[银联全渠道代扣退款] 异步回调 验签成功:flag=" + flag);
//                String respCode = respMap.get("respCode");
//                String respMsg = respMap.get("respMsg");
//                repDTO.setBankRtnCode(respCode);
//                repDTO.setBankRtnMsg(respMsg);
//
//                if ("00".equals(respCode)) {
//                    repDTO.setRefundStatus(EnumRefundStatus.SUCCESS);
//
//                    String traceTime = respMap.get("tradeTime");
//                    String orderId = respMap.get("orderId");
//                    String txnAmt = respMap.get("txnAmt");
//                    String queryId = respMap.get("queryId");
//                    repDTO.setBankOrderNo(orderId);
//                    repDTO.setBankRefundNo(queryId);
//                    Long amount = 0l;
//                    if (StringUtils.isNotBlank(txnAmt)) {
//                        repDTO.setRefundAmt(new BigDecimal(txnAmt));
//                    }
//                    Date bankFinishTime = null;
//                    if (StringUtils.isNotBlank(traceTime)) {
//                        String yyyy = DateUtil.DateToString(new Date(), "yyyy");
//                        bankFinishTime = DateUtil.StringToDate(yyyy + traceTime, "yyyyMMddHHmmss");
//                    }
//                    repDTO.setBankFinishDT(bankFinishTime);
//                } else if ("03".equals(respCode) || "04".equals(respCode) || "05".equals(respCode)) {
//                    repDTO.setRefundStatus(EnumRefundStatus.UNKNOW);
//                } else {
//                    repDTO.setRefundStatus(EnumRefundStatus.FAIL);
//                }
//            } else {
//                logger.info("#####[银联全渠道代扣退款] 回调验签失败:flag=" + flag);
//                repDTO.setRefundStatus(EnumRefundStatus.UNKNOW);
//            }
//        } catch (Exception e) {
//            logger.info("#####[银联全渠道代扣退款] 解析报文异常.", e);
//            throw new ResolveMsgException(EnumRtnResult.E030202);
//        }
//
//        return repDTO;
//    }
//}
