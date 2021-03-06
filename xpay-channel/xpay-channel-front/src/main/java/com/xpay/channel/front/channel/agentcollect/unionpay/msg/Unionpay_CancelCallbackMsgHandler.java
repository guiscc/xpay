//package com.xpay.channel.front.channel.agentcolletc.unionpay.msg;
//
//import com.xpay.channel.common.exception.BuildMsgException;
//import com.xpay.channel.common.exception.ResolveMsgException;
//import com.xpay.channel.common.util.DateUtil;
//import com.xpay.channel.front.channel.agentcollect.unionpay.util.UnionpayUtil;
//import com.xpay.channel.front.msg.impl.FmkChannelMsgHandlerImpl;
//import com.xpay.channel.front.utils.ChannelConfig;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Date;
//import java.util.Map;
//
///**
// * @Remark see class name
// * @Author pangyiyang
// * @Date 16/5/28 下午3:00
// */
//public class Unionpay_CancelCallbackMsgHandler extends FmkChannelMsgHandlerImpl<CancelCallbackReqDto,CancelCallbackRepDto> {
//
//    @Override
//    protected String getTemplatePath() {
//        return null;
//    }
//
//    private static final Logger logger = LoggerFactory.getLogger(Unionpay_CancelCallbackMsgHandler.class) ;
//
//    @Override
//    public byte[] builderMsg(CancelCallbackReqDto t, ChannelConfig channelConfig) throws BuildMsgException {
//        return "".getBytes() ;
//    }
//
//    @Override
//    public CancelCallbackRepDto resolveMsg(CancelCallbackReqDto reqDto, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
//        CancelCallbackRepDto repDto = new CancelCallbackRepDto() ;
//        try {
//            logger.info("#####[银联全渠道交易取消] 异步回调 处理开始.");
//            Map<String, String> map = reqDto.getMap();
//            logger.info("#####[[银联全渠道交易取消] 异步回调 返回Map为:" + map);
//            if (map == null || map.isEmpty()) {
//                logger.info("#####[银联全渠道交易取消] 异步回调 获取的返回报文为空.");
//                throw new ResolveMsgException(EnumSysRtnCode.R0004, EnumTradeStatus.UNKNOW);
//            }
//            boolean flag = UnionpayUtil.verSign(map, reqDto.getChannelRemark().getCerPath()) ;
//            if (flag) {
//                //拼装报文,并返回结果
//                logger.info("#####[银联全渠道交易取消] 异步回调 验签成功:flag=" + flag);
//                String respCode = map.get("respCode") ;
//                String respMsg = map.get("respMsg") ;
//                repDto.setRtnCode(respCode);
//                repDto.setRtnMsg(respMsg);
//
//                if("00".equals(respCode) ){
//                    repDto.setTradeStatus(EnumTradeStatus.SUCCESS);
//
//                    String traceTime = map.get("tradeTime") ;
//                    String orderId = map.get("orderId") ;
//                    String txnAmt = map.get("txnAmt") ;
//                    String queryId = map.get("queryId") ;
//                    repDto.setTradeStatus(EnumTradeStatus.SUCCESS);
//                    repDto.setChannelCancelNo(orderId);
//                    repDto.setBankNo(queryId);
//                    Long amount = 0l ;
//                    if(StringUtils.isNotBlank(txnAmt)){
//                        amount = Long.parseLong(txnAmt) ;
//                    }
//                    repDto.setAmount(amount);
//                    Date bankFinishTime = null ;
//                    if(StringUtils.isNotBlank(traceTime)){
//                        String yyyy = DateUtil.DateToString(new Date() , "yyyy") ;
//                        bankFinishTime = DateUtil.StringToDate(yyyy+traceTime , "yyyyMMddHHmmss") ;
//                    }
//                    repDto.setBankFinishTime(bankFinishTime);
//                    repDto.setChannelFinishTime(new Date());
//
//
//                }else if("03".equals(respCode) || "04".equals(respCode) || "05".equals(respCode)){
//                    repDto.setTradeStatus(EnumTradeStatus.UNKNOW);
//                }else{
//                    repDto.setTradeStatus(EnumTradeStatus.FAIL);
//                }
//
//            }else{
//                logger.info("#####[银联全渠道交易取消] 回调验签失败:flag=" + flag) ;
//                repDto.setTradeStatus(EnumTradeStatus.UNKNOW) ;
//                repDto.setRtnMsg("验签失败");
//                repDto.setRtnCode(EnumTradeStatus.UNKNOW.name());
//            }
//        }catch (Exception e){
//            logger.info("#####[银联全渠道交易取消] 解析报文异常." , e);
//            throw new ResolveMsgException(EnumSysRtnCode.R0000, EnumTradeStatus.UNKNOW);
//        }
//
//        return repDto;
//    }
//}
