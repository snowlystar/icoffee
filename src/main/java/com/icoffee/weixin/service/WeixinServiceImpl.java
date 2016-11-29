package com.icoffee.weixin.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Scope("singleton")
@Component("weixinService")
public class WeixinServiceImpl implements IWeixinService {
	RestTemplate restTemplate = new RestTemplate();
	
	// 
	WeixinToken currentToken;
	
	@Override
	public WeixinToken refreshToken(String appid, String secret) {
		String returnstring = restTemplate.getForObject(
				"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}",
				String.class, appid, secret);
		Gson gson = new Gson();
		WeixinToken token = gson.fromJson(returnstring, WeixinToken.class);
		currentToken = token;
		return token;
	}

	@Override
	public String getToken() {
		if (currentToken == null) {
			return null;
		}
		if (currentToken.isExpired()) {
			return null;
		}
		else {
			return currentToken.getAccess_token();
		}
	}

}
