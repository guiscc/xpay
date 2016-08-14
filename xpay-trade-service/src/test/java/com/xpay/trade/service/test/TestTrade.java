package com.xpay.trade.service.test;

import com.xpay.trade.service.dao.TradeDao;
import com.xpay.trade.service.entity.TradeEntity;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * Created by sxfans on 16/8/13.
 */
public class TestTrade extends BaseTest {

    @Resource
    private TradeDao tradeDao;

    //    @Test
    public void getByBizOrderNo() {
        System.out.println(tradeDao.getByBizOrderNo("123456"));
    }

//    @Test
    public void add() {
        int count = new Random().nextInt(1000);
        TradeEntity tradeEntity = new TradeEntity();
        tradeEntity.setBizOrderNo("2016081412060001"+count);
        tradeEntity.setTradeOrderNo("T2016081412060001"+count);
        tradeEntity.setBizType((short) 01);
        tradeEntity.setBizSubType((short) 02);
        tradeEntity.setOrderTime(new Date());
        tradeEntity.setExpireTime(new Date());
        tradeEntity.setPayNo("PAY2016081412060001"+count);
        tradeEntity.setPayAmount(new BigDecimal("200"));
        tradeEntity.setPayTime(new Date());
        tradeEntity.setTradeStatus((short) 00);
        tradeEntity.setCreateTime(new Date());
        tradeEntity.setUpdateTime(new Date());
        int i = tradeDao.add(tradeEntity);
        System.out.println(i);
    }

    @Test
    public void updateOrderStatus(){

    }
}
