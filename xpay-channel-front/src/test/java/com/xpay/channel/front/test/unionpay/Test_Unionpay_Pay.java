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
public class Test_Unionpay_Pay extends BaseTest {

    @Test
    public void pay() throws Exception {
        Map<String, String> data = new HashMap();

        /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
        data.put("version", "5.0.0");            //版本号 全渠道默认值
        data.put("encoding", "UTF-8");     //字符集编码 可以使用UTF-8,GBK两种方式
        data.put("signMethod", "01");                    //签名方法 目前只支持01：RSA方式证书加密
        data.put("txnType", "01");                        //交易类型 01:消费
        data.put("txnSubType", "01");                    //交易子类 01：消费
        data.put("bizType", "000201");                    //填写000201
        data.put("channelType", "08");                    //渠道类型 08手机

        Date date = new Date();
        String dateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

        /***商户接入参数***/
        data.put("merId", UnionpayUtil.merchantNo);    //商户号码，请改成自己申请的商户号或者open上注册得来的777商户号测试
        data.put("accessType", "0");                  //接入类型，商户接入填0 ，不需修改（0：直连商户， 1： 收单机构 2：平台商户）
        data.put("orderId", "201603300001");          //商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则
        data.put("txnTime", dateStr);                    //订单发送时间，取系统时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效
        data.put("accType", "01");                        //账号类型 01：银行卡02：存折03：IC卡帐号类型(卡介质)
        data.put("txnAmt", 10+"");                        //交易金额 单位为分，不能带小数点
        data.put("currencyCode", "156");                 //境内商户固定 156 人民币
        //contentData.put("reqReserved", "透传字段");              //商户自定义保留域，交易应答时会原样返回

        //后台通知地址（需设置为外网能访问 http https均可），支付成功后银联会自动将异步通知报文post到商户上送的该地址，【支付失败的交易银联不会发送后台通知】
        //后台通知参数详见open.unionpay.com帮助中心 下载  产品接口规范  网关支付产品接口规范 消费交易 商户通知
        //注意:1.需设置为外网能访问，否则收不到通知    2.http https均可  3.收单后台通知后需要10秒内返回http200或302状态码
        //    4.如果银联通知服务器发送通知后10秒内未收到返回状态码或者应答码非http200或302，那么银联会间隔一段时间再次发送。总共发送5次，银联后续间隔1、2、4、5 分钟后会再次通知。
        //    5.后台通知地址如果上送了带有？的参数，例如：http://abc/web?a=b&c=d 在后台通知处理程序验证签名之前需要编写逻辑将这些字段去掉再验签，否则将会验签失败
        data.put("backUrl", "www.baidu.com");

        UnionpayUtil.process(data,"https://101.231.204.80:5000/gateway/api/appTransReq.do");
    }
}
