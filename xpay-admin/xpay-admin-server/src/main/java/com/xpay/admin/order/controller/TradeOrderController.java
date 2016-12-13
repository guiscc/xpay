package com.xpay.admin.order.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.common.Common;
import com.xpay.admin.common.control.BaseController;
import com.xpay.admin.order.entity.TradeOrder;
import com.xpay.admin.order.service.TradeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("trade")
public class TradeOrderController extends BaseController {

	@Autowired
	private TradeOrderService xtradeOrderService;

	@RequestMapping(value = "queryList", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> getBankInfo(@RequestParam Integer rows, Integer page, TradeOrder dict) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = Common.DataValidation(dict);
		PageBounds pageBounds = buildPageBounds(rows, page, true);
		PageList<TradeOrder> list = xtradeOrderService.queryList(map, pageBounds);
		Map<String,Object> re = buildResult(rows, page, list);
		return re;
	}

//	@RequestMapping(value = "insBankInfo", method = RequestMethod.POST)
//	public @ResponseBody String insBankInfo(@RequestParam Integer rows, Integer page, BankCardBinDict dict) {
//        xtradeOrderService.insertBankBinInfo(dict);
//
//		return "";
//	}
//
//	@RequestMapping(value = "updBankInfo", method = RequestMethod.POST)
//	public @ResponseBody String updBankInfo(@RequestParam Integer rows, Integer page, BankCardBinDict dict) {
//        xtradeOrderService.updateBankBinInfo(dict);
//
//		return "";
//	}
}