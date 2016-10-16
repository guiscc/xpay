package com.xpay.channel.front.channel.daikou.unionpay.msg;

import com.xpay.channel.common.enums.EnumSysRtnCode;
import com.xpay.channel.common.enums.EnumTradeStatus;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.util.DateUtil;
import com.xpay.channel.common.util.JsonUtil;
import com.xpay.channel.front.channel.daikou.unionpay.Unionpay_Config;
import com.xpay.channel.front.channel.daikou.unionpay.util.UnionpayUtil;
import com.xpay.channel.front.msg.impl.FreemarkChannelMsgHandlerImpl;
import com.xpay.channel.front.utils.ChannelConfig;
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
 * @Date 16/5/23 下午8:10
 */
public class Unionpay_CancelMsgHandler extends FreemarkChannelMsgHandlerImpl<CancelReqDto,CancelRepDto> {
    @Override
    protected String getTemplatePath() {
        return null;
    }

    private static final Logger logger = LoggerFactory.getLogger(Unionpay_CancelMsgHandler.class) ;

    @Override
    public CancelReqDto beforBuildMsg(CancelReqDto req, ChannelConfig channelConfig) throws BuildMsgException {
        try {
            req = super.beforBuildMsg(req, channelConfig);
            Unionpay_Config config = (Unionpay_Config) channelConfig;
            req.setBankUrl(StringUtils.trim(config.getQueryUrl()));
            String charset = StringUtils.trim(config.getCharset());
            String encCerPath = StringUtils.trim(config.getEncCerPath()) ;


            Map<String, String> data = new HashMap<String, String>();
            /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
            data.put("version", StringUtils.trim(config.getVersion()));
            data.put("encoding", StringUtils.trim(config.getCharset()));
            data.put("signMethod", StringUtils.trim(config.getSignMethod()));
            data.put("txnType", StringUtils.trim(config.getCancelTxnType()));
            data.put("txnSubType", StringUtils.trim(config.getDaikouTxnSubType()));
            data.put("bizType", StringUtils.trim(config.getDaikouBizType()));
            data.put("channelType", StringUtils.trim(config.getChannelType()));

            /***商户接入参数***/
            data.put("merId", req.getChannelRemark().getMerchantNo());
            data.put("accessType", StringUtils.trim(config.getAccessType()));
            data.put("orderId", req.getChannelCancelNo());
            data.put("txnTime", DateUtil.DateToString(req.getChannelCreateDate(), "yyyyMMddHHmmss"));
            data.put("currencyCode", StringUtils.trim(config.getDaikouCurrencyCode()));
            data.put("txnAmt", String.valueOf(req.getAmount()));
            data.put("backUrl", StringUtils.trim(config.getNotifyUrl()));
            data.put("origQryId", req.getOriBankNo());

            /**对请求参数进行签名并发送http post请求，接收同步应答报文**/
            String pfxPath = req.getChannelRemark().getPfxPath() ;
            String pwd = req.getChannelRemark().getPwd() ;
            String sign = UnionpayUtil.sign(data, charset,pfxPath , pwd);
            data.put("signature", sign);
            logger.info("#####[银联消费撤销] 请求参数map为:" + data) ;
            super.put("map" , data);
        }catch (Exception e){
            logger.error("#####[银联消费撤销] 拼装参数异常." + req.getOriChannelOrderNo() , e);
            throw new BuildMsgException(EnumSysRtnCode.B0000 , EnumTradeStatus.FAIL) ;
        }
        return req ;
    }

    @Override
    public byte[] builderMsg(CancelReqDto req, ChannelConfig channelConfig) throws BuildMsgException {
        String charset = channelConfig.getCharset() ;
        Map<String , String> data = (Map<String, String>) super.get("map");
        String mapJson = JsonUtil.mapToStr(data) ;
        logger.info("[银联消费撤销] 传递参数为:" + mapJson);
        byte [] results = null ;
        try {
            results = mapJson.getBytes(charset) ;
        } catch (UnsupportedEncodingException e) {
            logger.error("#####[银联消费撤销] 拼参时 参数转换错误." + req.getOriChannelOrderNo() , e);
            throw new BuildMsgException(EnumSysRtnCode.B0000 , EnumTradeStatus.UNKNOW) ;
        }
        return results ;
    }

    @Override
    public CancelRepDto resolveMsg(CancelReqDto req, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
        CancelRepDto repDto = new CancelRepDto() ;
        repDto.setOriChannelOrderNo(req.getOriChannelOrderNo());
        repDto.setAmount(repDto.getAmount()) ;
        repDto.setRtnCode(EnumTradeStatus.UNKNOW.name()) ;
        repDto.setRtnMsg(EnumTradeStatus.UNKNOW.getValue()) ;
        repDto.setTradeStatus(EnumTradeStatus.UNKNOW);
        if(rtnMsg == null || rtnMsg.length ==0){
            throw new ResolveMsgException(EnumSysRtnCode.R0004 , EnumTradeStatus.UNKNOW);
        }

        try {
            String charset = StringUtils.trim(channelConfig.getCharset()) ;
            String jsonMap = new String(rtnMsg , charset) ;
            logger.info("#####[银联消费撤销] 通信返回参数为:" + jsonMap);
            Map<String , String> respMap = JsonUtil.jsonTomMap(jsonMap) ;
            boolean signFlag = UnionpayUtil.verSign(respMap , req.getChannelRemark().getCerPath());
            logger.info("#####[银联消费撤销] 验证签名信息结果:" + signFlag);
            String respCode = respMap.get("respCode") ;
            String respMsg = respMap.get("respMsg") ;
            String bankNo = respMap.get("queryId") ;
            repDto.setRtnCode(respCode);
            repDto.setRtnMsg(respMsg);
            repDto.setBankNo(bankNo);
            repDto.setChannelCancelNo(req.getChannelCancelNo());
            String txnAmount = respMap.get("txnAmt") ;
            logger.info("txnAmount=" + txnAmount);
            if(StringUtils.isNotBlank(txnAmount) && !"null".equals(txnAmount)){
                repDto.setAmount(Long.parseLong(txnAmount));
            }
            String traceTime = respMap.get("traceTime") ;
            if(StringUtils.isNotBlank(traceTime)){
                repDto.setBankFinishTime(DateUtil.StringToDate(traceTime , "MMddHHmmss"));
            }
            repDto.setChannelFinishTime(new Date());
            if("00".equals(respCode)){
                repDto.setTradeStatus(EnumTradeStatus.PROCESS);
            }else if("03".equals(respCode) || "04".equals(respCode) || "05".equals(respCode)){
                repDto.setTradeStatus(EnumTradeStatus.UNKNOW);
            }else{
                repDto.setTradeStatus(EnumTradeStatus.FAIL);
            }
            repDto.setOriChannelOrderNo(req.getOriChannelOrderNo());
            repDto.setAmount(req.getAmount());
        } catch (UnsupportedEncodingException e) {
            logger.error("#####[银联消费撤销] 解参时 参数转换错误." , e);
            throw new ResolveMsgException(EnumSysRtnCode.R0005 , EnumTradeStatus.UNKNOW);
        } catch (Exception e) {
            logger.error("#####[银联消费撤销] 解参时 出现异常." , e);
            throw new ResolveMsgException(EnumSysRtnCode.R0000 , EnumTradeStatus.UNKNOW);
        }

        return repDto;
    }
}
