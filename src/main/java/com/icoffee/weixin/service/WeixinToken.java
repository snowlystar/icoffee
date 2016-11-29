package com.icoffee.weixin.service;

import java.util.Calendar;

/**
 * access token
 * @author lixiaojing
 *
 */
public class WeixinToken {
	private Calendar updateTime = Calendar.getInstance();
	
	private String access_token;
	private long expires_in;
	private String errcode, errmsg;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}
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

	public boolean isExpired() {
		Calendar now = Calendar.getInstance();
		if ((now.getTimeInMillis() - updateTime.getTimeInMillis()) >= expires_in * 1000) {
			return true;
		}
		else {
			return false;
		}
	}
}
