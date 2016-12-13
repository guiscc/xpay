package com.xpay.admin.order.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.order.dao.TradeOrderMapper;
import com.xpay.admin.order.entity.TradeOrder;
import com.xpay.admin.order.service.TradeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("xtradeOrderService")
public class TradeOrderServiceImpl implements TradeOrderService {

	@Autowired
	private TradeOrderMapper tradeOrderMapper;
	
	@Override
	public PageList<TradeOrder> queryList(Map<String, Object> params, PageBounds pageBounds) {
		PageList<TradeOrder> bankList = tradeOrderMapper.selectByParams(params, pageBounds);
		return bankList;
	}

//	@Override
//	public Integer insertBankBinInfo(BankCardBinDict dict) {
//		Integer index = bankCardBinDictMapper.insertSelective(dict);
//		return index;
//	}

//	@Override
//	public void updateBankBinInfo(BankCardBinDict dict) {
//		bankCardBinDictMapper.updateByPrimaryKeySelective(dict);
//	}

//	@Override
//	public void deleteBankBinInfo(Long id) {
		// TODO Auto-generated method stub
//	}
}