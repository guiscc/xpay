package com.xpay.admin.common.exception;

/**
 * 
 * @author TanDong
 *
 */
public class HtmlException extends XpayAdminException {
	
	private static final long serialVersionUID = 1L;
	
	private String html;//
	
	public HtmlException(String errCode, String html) {
		super(errCode);
		this.html = html;
	}

	public HtmlException(String errCode) {
		super(errCode);
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
}
