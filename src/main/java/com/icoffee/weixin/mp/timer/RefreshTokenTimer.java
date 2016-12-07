package com.icoffee.weixin.mp.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.icoffee.weixin.mp.service.IWeixinService;

@Component
public class RefreshTokenTimer {
	@Autowired
	@Qualifier("appid")
	private String appid;
	
	@Autowired
	@Qualifier("appsecret")
	private String appsecret;
	
	@Autowired
	@Qualifier("weixinService")
	private IWeixinService weixinService;

	
	@Scheduled(fixedDelay=10800000, initialDelay=5000)
	void refreshToken() {
		weixinService.refreshToken(appid, appsecret);
	}
}
