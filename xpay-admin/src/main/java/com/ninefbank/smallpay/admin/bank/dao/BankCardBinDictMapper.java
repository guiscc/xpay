package com.ninefbank.smallpay.admin.bank.dao;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.bank.entity.BankCardBinDict;

public interface BankCardBinDictMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(BankCardBinDict record);

    int insertSelective(BankCardBinDict record);

    PageList<BankCardBinDict> selectByPrimaryKey(Map<String, Object> params, PageBounds pageBounds);

    int updateByPrimaryKeySelective(BankCardBinDict record);

    int updateByPrimaryKey(BankCardBinDict record);
}