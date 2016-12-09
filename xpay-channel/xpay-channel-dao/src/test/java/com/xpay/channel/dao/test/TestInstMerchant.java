package com.xpay.channel.dao.test;

import com.xpay.channel.dao.InstMerchantDao;
import com.xpay.channel.dao.entity.InstMerchantEntity;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hui on 2016/12/1.
 */
public class TestInstMerchant extends BaseTest   {
    @Resource
    private InstMerchantDao instMerchantDao;

    @Test
    public void getInstMerchantInfo() {
        String instCode = "\"ALIPAY\",\"UNIONPAY\"";
        List<InstMerchantEntity> instMerchantEntityList = instMerchantDao.findByInstCode(instCode);
        System.out.println(instMerchantEntityList);
    }
}
