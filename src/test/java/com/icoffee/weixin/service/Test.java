package com.icoffee.weixin.service;

import com.icoffee.weixin.mp.service.IWeixinMpService;
import com.icoffee.weixin.mp.service.WeixinMpServiceImpl;
import com.icoffee.weixin.mp.service.WeixinToken;

public class Test {
	private static IWeixinMpService weixinService;
	public static void main(String args[]) {
		weixinService = new WeixinMpServiceImpl();
		refreshToken();
		System.out.println(weixinService.getToken());
	}
	
	private static WeixinToken refreshToken() {
		return weixinService.refreshToken();
	}

}
