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
public class Test_Unionpay_CheckFile extends BaseTest {

    @Test
    public void checkfile() throws Exception {
        Map<String, String> data = new HashMap<String, String>();
        /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
        data.put("version", "5.0.0");               //版本号 全渠道默认值
        data.put("encoding", "UTF-8");             //字符集编码 可以使用UTF-8,GBK两种方式
        data.put("signMethod", "01");                        //签名方法 目前只支持01-RSA方式证书加密
        data.put("txnType", "76");                           //交易类型 76-对账文件下载
        data.put("txnSubType", "01");                        //交易子类型 01-对账文件下载
        data.put("bizType", "000000");                       //业务类型，固定

        Date date = new Date();
        String dateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

        /***商户接入参数***/
        data.put("accessType", "0");                         //接入类型，商户接入填0，不需修改
        data.put("merId", UnionpayUtil.merchantNo);                	         //商户代码，请替换正式商户号测试，如使用的是自助化平台注册的777开头的商户号，该商户号没有权限测文件下载接口的，请使用测试参数里写的文件下载的商户号和日期测。如需777商户号的真实交易的对账文件，请使用自助化平台下载文件。
        data.put("settleDate", dateStr);                  //清算日期，如果使用正式商户号测试则要修改成自己想要获取对账文件的日期， 测试环境如果使用700000000000001商户号则固定填写0119
        data.put("txnTime",dateStr);       //订单发送时间，取系统时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效
        data.put("fileType", "00");                          //文件类型，一般商户填写00即可

        UnionpayUtil.process(data,"https://101.231.204.80:9080/");
    }
}
