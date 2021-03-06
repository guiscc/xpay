package com.xpay.channel.front.test.unionpay;

import com.xpay.channel.common.util.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by suxinxin on 16/3/25.
 */
public class CerTest {
    public static void main(String[] args) throws Exception {
        Map<String, String> data = new HashMap();



        /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
        data.put("version", "5.0.0");                  //版本号
        data.put("encoding", "UTF-8");                //字符集编码 可以使用UTF-8,GBK两种方式
        data.put("signMethod", "01");                           //签名方法 目前只支持01-RSA方式证书加密
        data.put("txnType", "11");                              //交易类型 11-代收
        data.put("txnSubType", "00");                           //交易子类型  默认00
        data.put("bizType", "000501");                          //业务类型 代收产品
        data.put("channelType", "07");                          //渠道类型07-PC

        /***商户接入参数***/
        data.put("merId", "777290058123381");                   			   //商户号码（商户号码777290058110097仅做为测试调通交易使用，该商户号配置了需要对敏感信息加密）测试时请改成自己申请的商户号，【自己注册的测试777开头的商户号不支持代收产品】
        data.put("accessType", "0");                            //接入类型，商户接入固定填0，不需修改
        data.put("orderId", DateUtil.DateStampToStringNoSp(new Date()));             			   //商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则
        data.put("txnTime", DateUtil.DateToString(new Date() , "yyyyMMddHHmmss"));         				   //订单发送时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效
        data.put("currencyCode", "156");						   //交易币种（境内商户一般是156 人民币）
        data.put("txnAmt", "1");							   //交易金额，单位分，不要带小数点
        data.put("accType", "01");                              //账号类型

        Map<String,String> customerInfoMap = new HashMap<String,String>();
        //【代收的customerInfo送什么验证要素是配置到银联后台到商户号上的，这些验证要素可以在商户的《全渠道入网申请表》中找到，也可以请咨询您的业务人员或者银联业务运营接口人】
        //以下上送要素是参考《测试商户号777290058110097代收、实名认证交易必送验证要素配置说明.txt》贷记卡（实名认证交易-后台）部分
        customerInfoMap.put("certifTp", "01");						//证件类型
        customerInfoMap.put("certifId", "341126197709218366");		//证件号码
        customerInfoMap.put("customerNm", "全渠道");					//姓名
        customerInfoMap.put("phoneNo", "13552535506");			    //手机号

//        customerInfoMap.put("certifTp", "01");						//证件类型
//        customerInfoMap.put("certifId", "6221558812340000");		//证件号码
//        customerInfoMap.put("customerNm", "全渠道");					//姓名
//        customerInfoMap.put("phoneNo", "13552535506");			    //手机号
//        customerInfoMap.put("cvn2", "123");           			//卡背面的cvn2三位数字
//        customerInfoMap.put("expired", "1711");  				    //有效期 年在前月在后

        /////////不对敏感信息加密使用：
        //contentData.put("accNo", "6216261000000000018");            //这里测试的时候使用的是测试卡号，正式环境请使用真实卡号
        //String customerInfoStr = AcpService.getCustomerInfo(customerInfoMap,null,DemoBase.encoding_UTF8);
        ////////

        //////////如果商户号开通了  商户对敏感信息加密的权限那么，需要对 卡号accNo，pin和phoneNo，cvn2，expired加密（如果这些上送的话），对敏感信息加密使用：
        data.put("encryptCertId", UnionpayEncryptUtil.getCertId());
        String accNo = UnionpayEncryptUtil.encryptData("6216261000000000018" , "UTF-8") ;//AcpService.encryptData("6216261000000000018", "UTF-8");
        data.put("accNo", accNo);
        String customerInfoStr = UnionpayEncryptUtil.encryptData(customerInfoMap,"6216261000000000018","UTF-8") ;//AcpService.getCustomerInfoWithEncrypt(customerInfoMap,"6216261000000000018",DemoBase.encoding_UTF8);
        //////////

        data.put("customerInfo", customerInfoStr);

        //后台通知地址（需设置为【外网】能访问 http https均可），支付成功后银联会自动将异步通知报文post到商户上送的该地址，失败的交易银联不会发送后台通知
        //后台通知参数详见open.unionpay.com帮助中心 下载  产品接口规范  代收产品接口规范 代收交易 商户通知
        //注意:1.需设置为外网能访问，否则收不到通知    2.http https均可  3.收单后台通知后需要10秒内返回http200或302状态码
        //    4.如果银联通知服务器发送通知后10秒内未收到返回状态码或者应答码非http200，那么银联会间隔一段时间再次发送。总共发送5次，每次的间隔时间为0,1,2,4分钟。
        //    5.后台通知地址如果上送了带有？的参数，例如：http://abc/web?a=b&c=d 在后台通知处理程序验证签名之前需要编写逻辑将这些字段去掉再验签，否则将会验签失败
        data.put("backUrl", "http://www.baidu.com");
        //contentData.put("reqReserved", "111");                      					 //请求方保留域，透传字段（可以实现商户自定义参数的追踪）本交易的后台通知,对本交易的交易状态查询交易、对账文件中均会原样返回，商户可以按需上传，长度为1-1024个字节

        /**对请求参数进行签名并发送http post请求，接收同步应答报文**/
        String sign = UnionpayUtilaa.sign(data,"UTF-8") ;//AcpService.sign(contentData,DemoBase.encoding_UTF8);			 //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
        data.put("signature" , sign) ;			 //交易请求url从配置文件读取对应属性文件acp_sdk.properties中的 acpsdk.backTransUrl

        UnionpayUtilaa.process(data,"https://101.231.204.80:5000/gateway/api/backTransReq.do");
    }


}
