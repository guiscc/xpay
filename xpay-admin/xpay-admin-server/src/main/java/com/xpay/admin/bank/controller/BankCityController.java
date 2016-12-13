package com.xpay.admin.bank.controller;

import java.util.HashMap;
import java.util.Map;

import com.xpay.admin.common.Common;
import com.xpay.admin.common.control.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.bank.entity.BankCityInfo;
import com.xpay.admin.bank.service.BankCityService;

@Controller
@RequestMapping("bankCardCity")
public class BankCityController extends BaseController {

	@Autowired
	private BankCityService bCityService;

	@RequestMapping(value = "getBankInfo", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> getBankInfo(@RequestParam Integer rows, Integer page, BankCityInfo dict) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = Common.DataValidation(dict);
		PageBounds pageBounds = buildPageBounds(rows, page, true);
		PageList<BankCityInfo> list = bCityService.queryBankCitiesList(map, pageBounds);
		Map<String,Object> re = buildResult(rows, page, list);
		return re;
	}

	@RequestMapping(value = "insBankInfo", method = RequestMethod.POST)
	public @ResponseBody String insBankInfo(@RequestParam Integer rows, Integer page, BankCityInfo dict) {
		bCityService.insertBankCitiesInfo(dict);

		return "";
	}

	@RequestMapping(value = "updBankInfo", method = RequestMethod.POST)
	public @ResponseBody String updBankInfo(@RequestParam Integer rows, Integer page, BankCityInfo dict) {
		bCityService.updateBankCitiesInfo(dict);

		return "";
	}
}