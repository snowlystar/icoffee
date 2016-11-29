package com.icoffee.weixin.service;

public interface IWeixinService {
	/**
	 * Ë¢ÐÂtoken and store the token into cache
	 * @return
	 */
	WeixinToken refreshToken(String appid, String secret);
	
	/**
	 * get token from cache.
	 * if get null, call refreshToken to get a new one.
	 * @return
	 */
	String getToken();
}
