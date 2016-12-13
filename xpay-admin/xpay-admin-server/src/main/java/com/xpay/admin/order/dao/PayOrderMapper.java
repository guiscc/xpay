package com.xpay.admin.order.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.order.entity.PayOrder;

import java.util.Map;

public interface PayOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PayOrder record);

    int insertSelective(PayOrder record);

    PayOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PayOrder record);

    int updateByPrimaryKey(PayOrder record);

    PageList<PayOrder> selectByParams(Map<String, Object> params, PageBounds pageBounds);
}