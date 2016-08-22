package com.xpay.channel.front.test.unionpay;

import com.xpay.channel.front.test.BaseTest;
import org.junit.Test;

import java.util.*;

/**
 * Created by suxinxin on 16/3/25.
 */
public class Test_Unionpay_Query extends BaseTest {

    @Test
    public void query() throws Exception {
        Map<String, String> data = new HashMap<String, String>();
        data.put("version", "5.0.0");                 //版本号
        data.put("encoding", "UTF-8");          //字符集编码 可以使用UTF-8,GBK两种方式
        data.put("signMethod", "01");           //签名方法 目前只支持01-RSA方式证书加密
        data.put("txnType", "00");             //交易类型 00-默认
        data.put("txnSubType", "00");           //交易子类型  默认00
        data.put("bizType", "000201");          //业务类型

        data.put("merId", UnionpayUtil.merchantNo);                  //商户号码，请改成自己申请的商户号或者open上注册得来的777商户号测试
        data.put("accessType", "0");            //接入类型，商户接入固定填0，不需修改

        data.put("orderId", "201603300001");                            //****商户订单号，每次发交易测试需修改为被查询的交易的订单号
        data.put("txnTime", "20160330112918");                            //****订单发送时间，每次发交易测试需修改为被查询的交易的订单发送时间

        UnionpayUtil.process(data,"https://101.231.204.80:5000/gateway/api/queryTrans.do");

    }
}

