package com.xpay.channel.dao.test;

import com.xpay.channel.dao.PayToolsBankDao;
import com.xpay.channel.dao.entity.PayToolsBankEntity;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hui on 2016/12/1.
 */
public class TestPayToolsBank  extends BaseTest  {
    @Resource
    private PayToolsBankDao payToolsBankDao;

    @Test
    public void getPayToolsBankInfo() {
        PayToolsBankEntity inst = new PayToolsBankEntity();
        inst.setPayToolsCode(new Byte("0"));
        List<PayToolsBankEntity> cCfgEntity = payToolsBankDao.get(inst);
        System.out.println(cCfgEntity);
    }
}
