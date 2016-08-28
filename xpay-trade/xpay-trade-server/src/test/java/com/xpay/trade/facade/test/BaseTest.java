package com.xpay.trade.facade.test;

import com.xpay.trade.common.dto.*;
import com.xpay.trade.common.enums.EnumTradeStatus;
import com.xpay.trade.common.enums.EnumTradeSubType;
import com.xpay.trade.common.enums.EnumTradeType;
import com.xpay.trade.common.facade.TradeFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-hessian-test.xml" })
public class BaseTest {

    /**
     * 交易状态
     */
    @Resource
    private TradeFacade tradeFacade;

    //    @Test
    public void getTradeByBizOrderNo() {
        QueryTradeReqDTO queryTradeReqDTO = new QueryTradeReqDTO();
        queryTradeReqDTO.setBizOrderNo("2016081412060001");
        queryTradeReqDTO.setReqClientDT(new Date());
        QueryTradeRepDTO queryTradeRepDTO = tradeFacade.queryTrade(queryTradeReqDTO);
        System.out.println(queryTradeRepDTO.toString());
    }

    //    @Test
    public void updateTradeStatus() {
        UpOrderStatusReqDTO upOrderStatusReqDTO = new UpOrderStatusReqDTO();
        upOrderStatusReqDTO.setBizOrderNo("2016081412060001");
        upOrderStatusReqDTO.setOrderStatus(EnumTradeStatus.SUCCESS);
        UpOrderStatusRepDTO upOrderStatusRepDTO = tradeFacade
            .updateOrderStatus(upOrderStatusReqDTO);
        System.out.println(upOrderStatusRepDTO.toString());
    }

    /**
     * 订单创建
     */
    @Test
    public void trade() {
        TradeReqDTO tradeReqDTO = new TradeReqDTO();
        tradeReqDTO.setBizOrderNo("2016081412060005");
        tradeReqDTO.setTradeType(EnumTradeType.ACQUIRING);
        tradeReqDTO.setTradeSubType(EnumTradeSubType.GENERALACCEPT);
        tradeReqDTO.setGoodsName("测试商品002");
        tradeReqDTO.setPayAmt(new BigDecimal(9.49));
        tradeReqDTO.setReqClientDT(new Date());
        tradeReqDTO.setBizOrderTime(new Date());
        tradeReqDTO.setExpireTime(new Date());
        TradeRepDTO tradeRepDTO = tradeFacade.trade(tradeReqDTO);
        System.out.println(tradeRepDTO.toString());
    }

    @Test
    public void te() {
        System.out.println(new BigDecimal(9.9));
    }
}
