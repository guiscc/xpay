package com.xpay.trade.service.impl;

import com.xpay.common.utils.sequence.RandomSequenceImpl;
import com.xpay.common.utils.sequence.Sequence;
import com.xpay.trade.common.enums.EnumTradeStatus;
import com.xpay.trade.common.enums.EnumTradeSubType;
import com.xpay.trade.common.enums.EnumTradeType;
import com.xpay.trade.common.vo.QueryTradeRepVO;
import com.xpay.trade.common.vo.TradeRepVO;
import com.xpay.trade.common.vo.TradeReqVO;
import com.xpay.trade.service.TradeService;
import com.xpay.trade.service.dao.TradeDao;
import com.xpay.trade.service.entity.TradeEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 交易事务层
 * Created by sxfans on 16/8/13.
 */
@Service
public class TradeServiceImpl implements TradeService {

    /**
     * 交易持久化类
     */
    @Resource
    private TradeDao        tradeDao;

    private static Sequence sequence = new RandomSequenceImpl();

    @Override
    public TradeRepVO trade(TradeReqVO tradeReqDTO) {
        TradeEntity tradeEntity = this.convertTradeEntity(tradeReqDTO);
        TradeEntity oldTradeEntity = tradeDao.getByBizOrderNo(tradeEntity.getBizOrderNo());
        if (oldTradeEntity == null) {
            int flag = tradeDao.add(tradeEntity);
            if (flag == 1) {
                oldTradeEntity = tradeEntity;
            } else {
                return null;
            }
        }
        TradeRepVO tradeRepVO = this.convertTradeRepVO(oldTradeEntity);
        return tradeRepVO;
    }

    @Override
    public TradeRepVO getByBizOrderNo(String bizOrderNo) {
        TradeEntity tradeEntity = tradeDao.getByBizOrderNo(bizOrderNo);
        if(tradeEntity == null){
            return null;
        }
        TradeRepVO tradeRepVO = this.convertTradeRepVO(tradeEntity);
        return tradeRepVO;
    }

    @Override
    public boolean updateOrderStatus(String bizOrderNo, EnumTradeStatus tradeStatus) {
        TradeEntity tradeEntity = new TradeEntity();
        tradeEntity.setBizOrderNo(bizOrderNo);
        tradeEntity.setTradeStatus(tradeStatus.getKey());
        tradeEntity.setUpdateTime(new Date());
        int flag = tradeDao.updateOrderStatus(tradeEntity);
        if (flag != 1) {
            return false;
        }
        return true;
    }

    /**
     * 业务传输模型转换为持久化bean
     *
     * @return
     */
    private TradeEntity convertTradeEntity(TradeReqVO tradeReqVO) {
        TradeEntity tradeEntity = new TradeEntity();
        tradeEntity.setBizOrderNo(tradeReqVO.getBizOrderNo());
        tradeEntity.setTradeOrderNo(sequence.getSeq(null));
        tradeEntity.setTradeType(tradeReqVO.getTradeType().getKey());
        tradeEntity.setTradeSubType(tradeReqVO.getTradeSubType().getKey());
        tradeEntity.setExpireTime(tradeReqVO.getExpireTime());
        tradeEntity.setBizOrderTime(tradeReqVO.getBizOrderTime());
        tradeEntity.setPayAmt(tradeReqVO.getPayAmt());
        tradeEntity.setPayTime(tradeReqVO.getPayTime());
        tradeEntity.setTradeStatus(tradeReqVO.getTradeStatus().getKey());
        tradeEntity.setCreateTime(new Date());
        tradeEntity.setUpdateTime(new Date());
        return tradeEntity;
    }

    /**
     * @param tradeEntity
     * @return
     */
    private TradeRepVO convertTradeRepVO(TradeEntity tradeEntity) {
        TradeRepVO tradeRepVO = new TradeRepVO();
        tradeRepVO.setTradeOrderNo(tradeEntity.getTradeOrderNo());
        tradeRepVO.setTradeStatus(EnumTradeStatus.toTradeStatus(tradeEntity.getTradeStatus()));
        tradeRepVO.setPayTime(tradeEntity.getPayTime());
        tradeRepVO.setPayNo(tradeEntity.getPayNo());
        tradeRepVO.setPayAmt(tradeEntity.getPayAmt());
        tradeRepVO.setBizOrderNo(tradeEntity.getBizOrderNo());
        tradeRepVO.setTradeTpye(EnumTradeType.toTradeType(tradeEntity.getTradeType()));
        tradeRepVO.setTradeSubType(EnumTradeSubType.toTradeSubType(tradeEntity.getTradeSubType()));
        tradeRepVO.setCreateTime(tradeEntity.getCreateTime());
        tradeRepVO.setExpireTime(tradeEntity.getExpireTime());
        tradeRepVO.setId(tradeEntity.getId());
        tradeRepVO.setBizOrderTime(tradeEntity.getBizOrderTime());
        tradeRepVO.setUpdateTime(tradeEntity.getUpdateTime());
        return tradeRepVO;
    }
}
