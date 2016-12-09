package com.xpay.channel.dao.test;

import com.xpay.channel.dao.ChannelCfgDao;
import com.xpay.channel.dao.entity.ChannelCfgEntity;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by hui on 2016/12/1.
 */
public class TestChannelCfg  extends BaseTest  {

    @Resource
    private ChannelCfgDao channelCfgDao;

    @Test
    public void getChannelCfgInfo() {
        ChannelCfgEntity cCfgEntity = channelCfgDao.get("AC_ALIPAY_CD_01");
        System.out.println(cCfgEntity);
    }
}
