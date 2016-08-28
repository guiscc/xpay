package com.xpay.trade.service.test;

import com.xpay.trade.common.enums.EnumTradeStatus;
import com.xpay.trade.common.enums.EnumTradeSubType;
import com.xpay.trade.common.enums.EnumTradeType;
import com.xpay.trade.common.vo.TradeRepVO;
import com.xpay.trade.common.vo.TradeReqVO;
import com.xpay.trade.service.TradeService;
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
    private TradeService tradeService;

    @Test
    public void getByBizOrderNo() {
        TradeRepVO tradeRepVO = tradeService.getByBizOrderNo("2016081412060001");
        System.out.println(tradeRepVO);
    }

    @Test
    public void add() {
        TradeReqVO tradeReqVO = new TradeReqVO();
        tradeReqVO.setBizOrderNo("2016081412060005");
        tradeReqVO.setTradeType(EnumTradeType.PAYMENT);
        tradeReqVO.setTradeSubType(EnumTradeSubType.CASHREFUND);
        tradeReqVO.setBizOrderTime(new Date());
        tradeReqVO.setExpireTime(new Date());
        tradeReqVO.setPayAmt(new BigDecimal("1.11"));
        tradeReqVO.setPayTime(new Date());
        tradeReqVO.setGoodsName("测试商品001");
        tradeReqVO.setTradeStatus(EnumTradeStatus.WATING);
        TradeRepVO tradeRepVO = tradeService.trade(tradeReqVO);
        System.out.println(tradeRepVO.toString());
    }

    @Test
    public void updateOrderStatus() {
        boolean flag = tradeService.updateOrderStatus("2016081412060001", EnumTradeStatus.FAIL);
        System.out.println(flag);
    }
}
