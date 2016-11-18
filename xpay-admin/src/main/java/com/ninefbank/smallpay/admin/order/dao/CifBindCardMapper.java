package com.ninefbank.smallpay.admin.order.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.order.entity.CifBindCard;

import java.util.Map;

public interface CifBindCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CifBindCard record);

    int insertSelective(CifBindCard record);

    CifBindCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CifBindCard record);

    int updateByPrimaryKey(CifBindCard record);

    PageList<CifBindCard> selectByParams(Map<String, Object> params, PageBounds pageBounds);
}