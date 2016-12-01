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
        InstMerchantEntity  inst = new InstMerchantEntity();
        inst.setInstCode("UNIONPAY");
        List<InstMerchantEntity> cCfgEntity = instMerchantDao.get(inst);
        System.out.println(cCfgEntity);
    }
}
