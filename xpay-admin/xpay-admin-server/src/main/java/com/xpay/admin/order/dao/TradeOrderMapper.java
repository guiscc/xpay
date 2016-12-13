package com.xpay.admin.order.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.order.entity.TradeOrder;

import java.util.Map;

public interface TradeOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TradeOrder record);

    int insertSelective(TradeOrder record);

    TradeOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TradeOrder record);

    int updateByPrimaryKey(TradeOrder record);

    PageList<TradeOrder> selectByParams(Map<String, Object> params, PageBounds pageBounds);
}