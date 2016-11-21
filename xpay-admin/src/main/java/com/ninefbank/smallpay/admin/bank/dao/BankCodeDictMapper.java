package com.ninefbank.smallpay.admin.bank.dao;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.bank.entity.BankCodeDict;

public interface BankCodeDictMapper {
    int deleteByPrimaryKey(String bankCode);

    int insert(BankCodeDict record);

    int insertSelective(BankCodeDict record);

    PageList<BankCodeDict> selectByPrimaryKey(Map<String, Object> params, PageBounds pageBounds);

    int updateByPrimaryKeySelective(BankCodeDict record);

    int updateByPrimaryKey(BankCodeDict record);
}