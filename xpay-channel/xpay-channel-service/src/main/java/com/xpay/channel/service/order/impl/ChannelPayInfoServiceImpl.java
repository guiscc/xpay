/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.order.impl;

import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.model.ChannelOrderModel;
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

    @Resource(name = "bankOrderNoService")
    private OrderNoService orderNoService;

    @Resource
    private PayInfoDao payInfoDao;

    @Override
    public ChannelOrderModel add(RouterContext context, ACPayReqVO acPayReqVO) throws XpayChannelException {
        //插入订单
        ChannelOrderModel channelOrderModel = this.getByPayOrderNo(acPayReqVO.getPayOrderNo());
        if(channelOrderModel != null){ //如果订单存在就直接返回
            return channelOrderModel;
        }
        String orderNo = orderNoService.getOrderNo();
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
    public ChannelOrderModel getByPayOrderNo(String payOrderNo) {
        PayInfoEntity payInfoEntity = payInfoDao.findByPayOrderNo(payOrderNo);
        if(payInfoEntity != null){
            return buildACPayRepVO(payInfoEntity);
        }
        return null;
    }

    @Override
    public int endPayInfo(ChannelOrderModel channelOrderModel) {
        PayInfoEntity payInfoEntity = new PayInfoEntity();
        payInfoEntity.setPayOrderNo(channelOrderModel.getPayOrderNo());
        payInfoEntity.setPayStatus(channelOrderModel.getPayStatus().getKey());
        payInfoEntity.setBankNo(channelOrderModel.getBankNo());
        payInfoEntity.setRtnCode(channelOrderModel.getRtnCode());
        payInfoEntity.setRtnMsg(channelOrderModel.getRtnMsg());
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
    private ChannelOrderModel buildACPayRepVO(PayInfoEntity payInfoEntity){
        ACPayRepVO acPayRepVO = new ACPayRepVO();
        ChannelOrderModel channelOrderModel = new ChannelOrderModel();

        channelOrderModel.setPayAmt(payInfoEntity.getPayAmt());
        channelOrderModel.setCurrency(EnumCurrency.toCurrency(payInfoEntity.getCurrency()));

        channelOrderModel.setBankOrderNo(payInfoEntity.getBankOrderNo());
        channelOrderModel.setPayOrderNo(payInfoEntity.getPayOrderNo());
        channelOrderModel.setPaySubTool(EnumPaySubTool.toPaySubTool(payInfoEntity.getPaySubToolCode()));

        channelOrderModel.setChannelCode(payInfoEntity.getChannelCode());
        channelOrderModel.setCreateTime(payInfoEntity.getCreateDT());
        channelOrderModel.setPayStatus(EnumPayStatus.toPayTool(payInfoEntity.getPayStatus()));
        channelOrderModel.setRtnCode(payInfoEntity.getRtnCode());
        channelOrderModel.setRtnMsg(payInfoEntity.getRtnMsg());
        channelOrderModel.setFinishDT(payInfoEntity.getFinishDT());
        channelOrderModel.setMerchantNo(payInfoEntity.getMerchantNo());
        return channelOrderModel;
    }
}