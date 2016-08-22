package com.xpay.trade.facade.test;

import com.xpay.trade.common.dto.QueryTradeRepDTO;
import com.xpay.trade.common.dto.QueryTradeReqDTO;
import com.xpay.trade.common.facade.TradeFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-hessian-test.xml"})
public class BaseTest {

    /**
     * 交易状态
     */
    @Resource
    private TradeFacade tradeFacade;

    @Test
    public void getTradeByBizOrderNo() {
        QueryTradeReqDTO queryTradeReqDTO = new QueryTradeReqDTO();
        queryTradeReqDTO.setBizOrderNo("2016081412060002");
        queryTradeReqDTO.setReqClientDT(new Date());
        QueryTradeRepDTO queryTradeRepDTO = tradeFacade.queryTrade(queryTradeReqDTO);
        System.out.println(queryTradeRepDTO.toString());
    }
}
