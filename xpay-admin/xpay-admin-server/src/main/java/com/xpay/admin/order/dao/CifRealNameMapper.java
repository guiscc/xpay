package com.xpay.admin.order.dao;

import com.xpay.admin.order.entity.CifRealName;

public interface CifRealNameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CifRealName record);

    int insertSelective(CifRealName record);

    CifRealName selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CifRealName record);

    int updateByPrimaryKey(CifRealName record);
}