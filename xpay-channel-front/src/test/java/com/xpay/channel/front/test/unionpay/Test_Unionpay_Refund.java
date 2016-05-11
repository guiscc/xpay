package com.xpay.channel.front.test.unionpay;

import com.xpay.channel.front.test.BaseTest;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by suxinxin on 16/3/29.
 */
public class Test_Unionpay_Refund extends BaseTest {

    @Test
    public void refund() throws Exception {
        Map<String, String> data = new HashMap<String, String>();

        /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
        data.put("version", "5.0.0");               //版本号
        data.put("encoding", "UTF-8");             //字符集编码 可以使用UTF-8,GBK两种方式
        data.put("signMethod", "01");                        //签名方法 目前只支持01-RSA方式证书加密
        data.put("txnType", "04");                           //交易类型 04-退货
        data.put("txnSubType", "00");                        //交易子类型  默认00
        data.put("bizType", "000201");                       //业务类型
        data.put("channelType", "08");                       //渠道类型，07-PC，08-手机

        Date date = new Date();
        String dateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

        /***商户接入参数***/
        data.put("merId", UnionpayUtil.merchantNo);                //商户号码，请改成自己申请的商户号或者open上注册得来的777商户号测试
        data.put("accessType", "0");                         //接入类型，商户接入固定填0，不需修改
        data.put("orderId", "2016032901");          //商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则，重新产生，不同于原消费
        data.put("txnTime", dateStr);      //订单发送时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效
        data.put("currencyCode", "156");                     //交易币种（境内商户一般是156 人民币）
        data.put("txnAmt", 1 + "");                          //****退货金额，单位分，不要带小数点。退货金额小于等于原消费金额，当小于的时候可以多次退货至退货累计金额等于原消费金额
        //data.put("reqReserved", "透传信息");                    //请求方保留域，透传字段（可以实现商户自定义参数的追踪）本交易的后台通知,对本交易的交易状态查询交易、对账文件中均会原样返回，商户可以按需上传，长度为1-1024个字节
        data.put("backUrl", "www.baidu.com");               //后台通知地址，后台通知参数详见open.unionpay.com帮助中心 下载  产品接口规范  网关支付产品接口规范 退货交易 商户通知,其他说明同消费交易的后台通知

        /***要调通交易以下字段必须修改***/
        data.put("origQryId", "201603290001");      //****原消费交易返回的的queryId，可以从消费交易后台通知接口中或者交易状态查询接口中获取

        UnionpayUtil.process(data,"https://101.231.204.80:5000/gateway/api/appTransReq.do");
    }
}
