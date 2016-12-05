package com.xpay.channel.dao.test;

import com.xpay.channel.dao.PayToolsBankDao;
import com.xpay.channel.dao.entity.PayToolsBankEntity;
import com.xpay.common.enums.EnumCardType;
import com.xpay.common.enums.EnumPaySubTool;
import com.xpay.common.enums.EnumPayTool;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hui on 2016/12/1.
 */
public class TestPayToolsBank extends BaseTest {
    @Resource
    private PayToolsBankDao payToolsBankDao;

    @Test
    public void getPayToolsBankInfo() {
        PayToolsBankEntity inst = new PayToolsBankEntity();
        inst.setPayToolsCode(EnumPayTool.BANKCARD.getKey());
        inst.setPaySubToolsCode(EnumPaySubTool.AGENTCOLLECT.getKey());
        inst.setPayToolCardType(EnumCardType.DEBIT.getKey());
        PayToolsBankEntity payToolsBankEntity = payToolsBankDao.get(0, 1, 1, "ABC");
        System.out.println(payToolsBankEntity);
    }
}
