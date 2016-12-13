package com.xpay.admin.order.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.order.dao.ChannelOrderMapper;
import com.xpay.admin.order.entity.ChannelOrder;
import com.xpay.admin.order.service.ChannelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("xchannelOrderService")
public class ChannelOrderServiceImpl implements ChannelOrderService {

	@Autowired
	private ChannelOrderMapper channelOrderMapper;
	
	@Override
	public PageList<ChannelOrder> queryList(Map<String, Object> params, PageBounds pageBounds) {
		PageList<ChannelOrder> bankList = channelOrderMapper.selectByParams(params, pageBounds);
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