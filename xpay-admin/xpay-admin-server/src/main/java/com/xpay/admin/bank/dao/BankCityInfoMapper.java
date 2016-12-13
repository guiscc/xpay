package com.xpay.admin.bank.dao;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.bank.entity.BankCityInfo;

public interface BankCityInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(BankCityInfo record);

    int insertSelective(BankCityInfo record);

    PageList<BankCityInfo> selectByPrimaryKey(Map<String, Object> params, PageBounds pageBounds);

    int updateByPrimaryKeySelective(BankCityInfo record);

    int updateByPrimaryKey(BankCityInfo record);
}