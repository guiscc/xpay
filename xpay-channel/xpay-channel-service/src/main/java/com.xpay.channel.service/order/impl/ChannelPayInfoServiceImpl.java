/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.order.impl;

import com.xpay.channel.common.dto.PayOrderDTO;
import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.model.PayOrderModel;
import com.xpay.channel.common.vo.agentcollect.ACPayRepVO;
import com.xpay.channel.common.vo.agentcollect.ACPayReqVO;
import com.xpay.channel.dao.PayInfoDao;
import com.xpay.channel.dao.entity.PayInfoEntity;
import com.xpay.channel.service.order.ChannelPayInfoService;
import com.xpay.channel.service.order.OrderNoService;
import com.xpay.channel.service.router.RouterContext;
import com.xpay.common.enums.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: ChannelPayInfoServiceImpl.java, v 0.1 16/12/1 下午4:29 sxfans Exp $
 */
@Service
public class ChannelPayInfoServiceImpl implements ChannelPayInfoService{

    @Resource
    private OrderNoService orderNoService;

    @Resource
    private PayInfoDao payInfoDao;

    @Override
    public ACPayRepVO add(RouterContext context, ACPayReqVO acPayReqVO) throws XpayChannelException {
        //插入订单
        ACPayRepVO payRepVOold = this.getByPayOrderNo(acPayReqVO.getPayOrderNo());
        if(payRepVOold != null){ //如果订单存在就直接返回
            return payRepVOold;
        }
        String orderNo = orderNoService.getOrderNo();
        acPayReqVO.setBankOrderNo(orderNo);
        PayInfoEntity payInfoEntity = new PayInfoEntity();
        payInfoEntity.setBankOrderNo(orderNo);
        payInfoEntity.setPayToolsBankCode(context.getPayToolsBankEntity().getPayToolBankCode());
        payInfoEntity.setMerchantNo(context.getInstMerchantEntity().getMerchantNo());
        payInfoEntity.setChannelCode(context.getChannelEntity().getChannelCode());
        payInfoEntity.setCreateDT(new Date());
        payInfoEntity.setCurrency(acPayReqVO.getCurrency().getKey());
        payInfoEntity.setPayOrderNo(acPayReqVO.getPayOrderNo());
        payInfoEntity.setPayAmt(acPayReqVO.getPayAmt());
        payInfoEntity.setPayStatus(EnumPayStatus.WAITING.getKey());
        int flag = payInfoDao.add(payInfoEntity);
        if(flag != 1){
            throw new XpayChannelException(EnumRtnResult.E000000);
        }
        return buildACPayRepVO(payInfoEntity);
    }

    @Override
    public ACPayRepVO getByPayOrderNo(String payOrderNo) {
        PayInfoEntity payInfoEntity = payInfoDao.findByPayOrderNo(payOrderNo);
        if(payInfoEntity != null){
            return buildACPayRepVO(payInfoEntity);
        }
        return null;
    }

    @Override
    public int endPayInfo(ACPayRepVO acPayRepVO) {
        PayInfoEntity payInfoEntity = new PayInfoEntity();
        PayOrderModel payOrderModel = acPayRepVO.getPayOrderModel();
        payInfoEntity.setPayOrderNo(payOrderModel.getPayOrderNo());
        payInfoEntity.setPayStatus(payOrderModel.getPayStatus().getKey());
        payInfoEntity.setBankNo(payOrderModel.getBankNo());
        payInfoEntity.setRtnCode(payOrderModel.getRtnCode());
        payInfoEntity.setRtnMsg(payOrderModel.getRtnMsg());
        payInfoEntity.setFinishDT(new Date());
        payInfoEntity.setBankFinishDT(new Date());
        int flag =payInfoDao.updateByPayOrderNo(payInfoEntity);
        return flag;
    }


    /**
     * 转换
     * @param payInfoEntity
     * @return
     */
    private ACPayRepVO buildACPayRepVO(PayInfoEntity payInfoEntity){
        ACPayRepVO acPayRepVO = new ACPayRepVO();
        PayOrderModel payOrderModel = new PayOrderModel();

        payOrderModel.setPayAmt(payInfoEntity.getPayAmt());
        payOrderModel.setCurrency(EnumCurrency.toCurrency(payInfoEntity.getCurrency()));

        payOrderModel.setBankOrderNo(payInfoEntity.getBankOrderNo());
        payOrderModel.setPayOrderNo(payInfoEntity.getPayOrderNo());
        payOrderModel.setPaySubTool(EnumPaySubTool.toPaySubTool(payInfoEntity.getPaySubToolCode()));

        payOrderModel.setChannelCode(payInfoEntity.getChannelCode());
        payOrderModel.setCreateTime(payInfoEntity.getCreateDT());
        payOrderModel.setPayStatus(EnumPayStatus.toPayTool(payInfoEntity.getPayStatus()));
        payOrderModel.setRtnCode(payInfoEntity.getRtnCode());
        payOrderModel.setRtnMsg(payInfoEntity.getRtnMsg());
        acPayRepVO.setPayOrderModel(payOrderModel);
        return acPayRepVO;
    }
}