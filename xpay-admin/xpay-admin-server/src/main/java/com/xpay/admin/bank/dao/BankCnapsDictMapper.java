package com.xpay.admin.bank.dao;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.bank.entity.BankCnapsDict;

public interface BankCnapsDictMapper {
    int deleteByPrimaryKey(String bankCnaps);

    int insert(BankCnapsDict record);

    int insertSelective(BankCnapsDict record);

    PageList<BankCnapsDict> selectByPrimaryKey(Map<String, Object> params, PageBounds pageBounds);

    int updateByPrimaryKeySelective(BankCnapsDict record);

    int updateByPrimaryKey(BankCnapsDict record);
}