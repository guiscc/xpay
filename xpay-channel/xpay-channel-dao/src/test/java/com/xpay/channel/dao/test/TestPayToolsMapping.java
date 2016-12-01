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
        PayToolsMappingEntity inst = new PayToolsMappingEntity();
        inst.setPaySubToolCode(1l);
        List<PayToolsMappingEntity> cCfgEntity = payToolsMappingDao.get(inst);
        System.out.println(cCfgEntity);
    }
}
