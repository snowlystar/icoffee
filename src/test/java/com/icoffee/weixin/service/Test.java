package com.icoffee.weixin.service;

public class Test {
	private static IWeixinService weixinService;
	public static void main(String args[]) {
		weixinService = new WeixinServiceImpl();
		refreshToken();
		System.out.println(weixinService.getToken());
	}
	
	private static WeixinToken refreshToken() {
		return weixinService.refreshToken("wxa1a8fc745855c04d", "efdc85357888bed49f6797dced8074bf");
	}

}
