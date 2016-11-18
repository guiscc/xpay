package com.ninefbank.smallpay.admin.sysmgr.web;

import com.ninefbank.smallpay.admin.sysmgr.entity.SysDictItem;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysDictType;

import java.io.Serializable;
import java.util.List;

/**
 * 用于缓存的VO对象
 * 
 * @author wangzhenlei
 *
 */
public class DictCache implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<SysDictType> dictTypes;
	
	private List<SysDictItem> dictItems;

	public List<SysDictType> getDictTypes() {
		return dictTypes;
	}

	public void setDictTypes(List<SysDictType> dictTypes) {
		this.dictTypes = dictTypes;
	}

	public List<SysDictItem> getDictItems() {
		return dictItems;
	}

	public void setDictItems(List<SysDictItem> dictItems) {
		this.dictItems = dictItems;
	}

}
