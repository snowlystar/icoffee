package com.icoffee.weixin.mp.service;

/**
 * the return message from rest service
 * @author lixiaojing
 *
 */
public class RestResponse {
	private String errcode, errmsg;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
