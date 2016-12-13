package com.xpay.admin.common.model;

import java.io.Serializable;
import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.Paginator;
/***
 * 分页模板
 * @author luojiaoxia
 *
 * @param <T>
 */
public final class PageModel<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3159444835348506304L;

	public List<T> resultList;
	
	public Paginator paginator;

	
	public PageModel(List<T> resultList, Paginator paginator){
		this.resultList = resultList;
		this.paginator = paginator;
	}
	
	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}
	
}
