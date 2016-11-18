package com.ninefbank.smallpay.admin.order.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.order.entity.ChannelOrder;

import java.util.Map;

public interface ChannelOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelOrder record);

    int insertSelective(ChannelOrder record);

    ChannelOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelOrder record);

    int updateByPrimaryKey(ChannelOrder record);

    PageList<ChannelOrder> selectByParams(Map<String, Object> params, PageBounds pageBounds);
}