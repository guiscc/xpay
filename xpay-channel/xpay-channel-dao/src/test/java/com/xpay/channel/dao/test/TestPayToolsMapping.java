package com.xpay.channel.dao.test;

import com.xpay.channel.dao.PayToolsMappingDao;
import com.xpay.channel.dao.entity.PayToolsMappingEntity;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hui on 2016/12/1.
 */
public class TestPayToolsMapping  extends BaseTest   {
    @Resource
    private PayToolsMappingDao payToolsMappingDao;

    @Test
    public void getPayToolsMappingInfo() {
        List<PayToolsMappingEntity> payToolsMappingEntityList = payToolsMappingDao.find("AC_ABC_D");
        System.out.println(payToolsMappingEntityList);
    }
}
