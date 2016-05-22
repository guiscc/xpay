package com.xpay.channel.front.channel.daikou.unionpay.msg;

import com.xpay.channel.common.dto.daikou.RealNameAuthRepDto;
import com.xpay.channel.common.dto.daikou.RealNameAuthReqDto;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.util.DateUtil;
import com.xpay.channel.front.channel.daikou.unionpay.Unionpay_Config;
import com.xpay.channel.front.msg.impl.FreemarkChannelMsgHandlerImpl;
import com.xpay.channel.front.utils.ChannelConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午1:39
 */
public class Unionpay_AuthMsgHandler extends FreemarkChannelMsgHandlerImpl<RealNameAuthReqDto,RealNameAuthRepDto> {
    @Override
    protected String getTemplatePath() {
        return null;
    }

    private static final Logger logger = LoggerFactory.getLogger(Unionpay_AuthMsgHandler.class) ;

    @Override
    public RealNameAuthReqDto beforBuildMsg(RealNameAuthReqDto req, ChannelConfig channelConfig) throws BuildMsgException {
//        req = super.beforBuildMsg(req , channelConfig) ;
//        Unionpay_Config config = (Unionpay_Config)channelConfig;
//        config.setPxfPath(req.getPfxPath());
//        config.setPxfPass(req.getPfxPass());
//        config.setBankURL(config.getAuthUrl());
//
//
//        /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
//        super.put("version", StringUtils.trim(config.getVersion()));        //版本号
//        super.put("encoding", StringUtils.trim(config.getCharset()));       //字符集编码 可以使用UTF-8,GBK两种方式
//        super.put("signMethod", StringUtils.trim(config.getSignMethod()));  //签名方法 目前只支持01-RSA方式证书加密
//        super.put("txnType", StringUtils.trim(config.getTxnType()));        //交易类型 11-代收
//        super.put("txnSubType", StringUtils.trim(config.getTxnType()));     //交易子类型  02：免验建立绑定关系    正式环境是01
//        super.put("bizType", StringUtils.trim(config.getBizType()));        //业务类型 代收产品
//        super.put("channelType", StringUtils.trim(config.getChannelType()));//渠道类型07-PC
//
//        /***商户接入参数***/
//        super.put("merId", req.getChannelRemark().getMerchantNo());         //商户号码（本商户号码仅做为测试调通交易使用，该商户号配置了需要对敏感信息加密）测试时请改成自己申请的商户号，【自己注册的测试777开头的商户号不支持代收产品】
//        super.put("accessType", StringUtils.trim(config.getAccessType()));  //接入类型，商户接入固定填0，不需修改
//        super.put("orderId", req.getChannelOrderNo());                      //商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则
//        super.put("txnTime", DateUtil.DateToString(new Date() , "yyyyMMddHHmmss"));//订单发送时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效
//        super.put("accType", StringUtils.trim(config.getAccType()));                              //账号类型
//
//        //实名认证交易的customerInfo送什么验证要素一般在入网的时候银联业务会与商户业务商谈好这些内容，
//        //请咨询您的业务人员或者银联业务运营的同事，银联端不做配置
//        Map<String,String> customerInfoMap = new HashMap<String,String>();
//        customerInfoMap.put("certifTp", "01");						//证件类型
//        customerInfoMap.put("certifId", "341126197709218366");		//证件号码
//        //customerInfoMap.put("customerNm", "互联网");				//姓名
//        //customerInfoMap.put("phoneNo", "13552535506");			//手机号
//        //customerInfoMap.put("pin", "123456");						//密码
//        customerInfoMap.put("cvn2", "123");           			    //卡背面的cvn2三位数字
//        customerInfoMap.put("expired", "1711");  				    //有效期 年在前月在后
//
//        super.put("bindId", "MYBindIdTest1");       //【本交易中bindId必送】可以自行定义 1-128位字母、数字和/或特殊符号字符,代收使用Form09_6_2_DaiShou_BindId.java
//
//        //////////如果商户号开通了【商户对敏感信息加密】的权限那么需要对 accNo，pin和phoneNo，cvn2，expired加密（如果这些上送的话）对敏感信息加密使用：
//        String accNo = AcpService.encryptData("6221558812340000", "UTF-8");  //【贷记卡】这里测试的时候使用的是测试卡号，正式环境请使用真实卡号
//        super.put("accNo", accNo);
//        super.put("encryptCertId", CertUtil.getEncryptCertId()); 	 //加密证书的certId，配置在acp_sdk.properties文件 acpsdk.encryptCert.path属性下
//        String customerInfoStr = AcpService.getCustomerInfoWithEncrypt(customerInfoMap,null,StringUtils.trim(config.getCharset()));
//        //////////
//
//        /////////如果商户号未开通【商户对敏感信息加密】权限那么不需对敏感信息加密使用：
//        //contentData.put("accNo", "6221558812340000");            		 //这里测试的时候使用的是测试卡号，正式环境请使用真实卡号
//        //String customerInfoStr = DemoBase.getCustomerInfo(customerInfoMap,null);
//        ////////
//
//        super.put("customerInfo", customerInfoStr);

        return null ;
    }

    @Override
    public byte[] builderMsg(RealNameAuthReqDto req, ChannelConfig channelConfig) throws BuildMsgException {
//        Map<String , String> reqData = new HashMap<String , String>() ;
//        for(Map.Entry<String , Object> entry : super.map.get().entrySet()){
//            String key = entry.getKey() ;
//            String value = (String) entry.getValue();
//            reqData.put(key , value) ;
//        }
//        Map<String, String> rspData = AcpService.post( reqData ,channelConfig.getBankURL(),channelConfig.getCharset());		//发送请求报文并接受同步应答（默认连接超时时间30秒，读取返回结果超时时间30秒）;这里调用signData之后，调用submitUrl之前不能对submitFromData中的键值对做任何修改，如果修改会导致验签不通过
//        logger.info("#####返回参数为:" + rspData);
//        /**对应答码的处理，请根据您的业务逻辑来编写程序,以下应答码处理逻辑仅供参考------------->**/
//        //应答码规范参考open.unionpay.com帮助中心 下载  产品接口规范  《平台接入接口规范-第5部分-附录》
//        if(!rspData.isEmpty()){
//            if(AcpService.validate(rspData, channelConfig.getCharset())){
//                logger.info("签名验证成功");
//                String respCode = rspData.get("respCode") ;
//                if(("00").equals(respCode)){
//
//                }else{
//                    //其他应答码为失败请排查原因或做失败处理
//                    //TODO
//                }
//            }else{
//                logger.info("签名验证失败");
//                //TODO 检查验证签名失败的原因
//            }
//        }else{
//            //未返回正确的http状态
//            logger.info("未获取到返回报文或返回http状态码非200");
//        }
//        String reqMessage = DemoBase.genHtmlResult(reqData);
//        String rspMessage = DemoBase.genHtmlResult(rspData);
//        resp.getWriter().write("请求报文:<br/>"+reqMessage+"<br/>" + "应答报文:</br>"+rspMessage+"");
        return null ;
    }

    @Override
    public RealNameAuthRepDto resolveMsg(RealNameAuthReqDto req, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
        return super.resolveMsg(req, rtnMsg, channelConfig);
    }
}
