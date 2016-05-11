package com.xpay.channel.front.test;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import com.xpay.channel.front.facade.QuickPayChannelFacade;
import com.xpay.channel.front.mapping.QuickChannelMappingFactory;
import org.junit.Before;
import org.junit.Test;

import com.xpay.channel.common.dto.quick.PayConfirmReqDTO;
import com.xpay.channel.common.dto.quick.PayQueryRepDTO;
import com.xpay.channel.common.dto.quick.PayQueryReqDTO;
import com.xpay.channel.common.dto.quick.SignConfirmReqDTO;
import com.xpay.channel.common.dto.quick.SignRepDTO;
import com.xpay.channel.common.dto.quick.SignReqDTO;
import com.xpay.channel.common.enums.EnumCertType;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;

/**
 * Created by suxinxin on 16/2/5.
 */
public class TestBillpay extends BaseTest {
    @Resource
    private QuickChannelMappingFactory quickChannelMappingFactory;

    QuickPayChannelFacade quickPayChannelFacade;

    @Before
    public void setUp() throws Exception {
        quickPayChannelFacade = quickChannelMappingFactory.getChannelBean("QP_BILLPAY_CD_01");
    }

//   @Test
    public void sign() throws VldException, BuildMsgException, ResolveMsgException, CommuException {
        SignReqDTO signReqDTO = new SignReqDTO();
        signReqDTO.setUserId("123456789");
        signReqDTO.setChannelSignNo("1234567890");
        signReqDTO.setCardNo("6214850103294915");
        signReqDTO.setCertCode("410926199110034413");
        signReqDTO.setMobileNo("18701113092");
        signReqDTO.setHolderName("赵建国");
        signReqDTO.setCertType(EnumCertType.ID);
        signReqDTO.setMerchantNo("812310060110178");
        signReqDTO.setPfxPath("E:\\workspace\\smallpay\\smallpay-channel\\src\\main\\resources\\kq\\81231006011017890.jks");
        signReqDTO.setPfxPass("vpos123");
        SignRepDTO signRepDTO = quickPayChannelFacade.sign(signReqDTO);
        System.out.println(signRepDTO);
    }

    //@Test
    public void signConfirm() throws VldException, BuildMsgException, CommuException, ResolveMsgException{
    	SignConfirmReqDTO dto = new SignConfirmReqDTO();
    	dto.setUserId("123456789");
    	dto.setCardNo("6214430101294915");
    	dto.setMobileNo("18701113092");
    	dto.setOrderNo("1234567890");
    	dto.setToken("379387137");
    	dto.setVaildCode("645618");
    	dto.setMerchantNo("812310060110178");
    	dto.setPfxPath("E:\\workspace\\smallpay\\smallpay-channel\\src\\main\\resources\\kq\\81231006011017890.jks");
    	dto.setPfxPass("vpos123");
    	quickPayChannelFacade.signConfirm(dto);
    }
    
    @Test
    public void testPay() throws VldException, BuildMsgException, CommuException, ResolveMsgException{
    	PayConfirmReqDTO reqDTO = new PayConfirmReqDTO();
    	reqDTO.setOriSignNo("6214293915");
    	reqDTO.setAmount(new BigDecimal("0.1"));
    	reqDTO.setReqTime(new Date());
    	reqDTO.setChannelPayNo("123456789");
    	reqDTO.setUserId("123456789");
    	reqDTO.setMerchantNo("812310060110178");
    	reqDTO.setPfxPath("E:\\workspace\\smallpay\\smallpay-channel\\src\\main\\resources\\kq\\81231006011017890.jks");
    	reqDTO.setPfxPass("vpos123");
    	quickPayChannelFacade.pay(reqDTO);
    }
    
//    @Test
    public void queryPay() throws BuildMsgException, ResolveMsgException, VldException, CommuException {
        PayQueryReqDTO queryPayReqDTO = new PayQueryReqDTO();
        queryPayReqDTO.setOriChannelPayNo("12001160113164414013194");
        queryPayReqDTO.setMerchantNo("812310060110178");
        queryPayReqDTO.setPfxPath("E:\\workspace\\smallpay\\smallpay-channel\\src\\main\\resources\\kq\\81231006011017890.jks");
        queryPayReqDTO.setPfxPass("vpos123");
        PayQueryRepDTO queryPayRepDTO = quickPayChannelFacade.queryPay(queryPayReqDTO);
        System.out.println(queryPayRepDTO);
    }
    
}
