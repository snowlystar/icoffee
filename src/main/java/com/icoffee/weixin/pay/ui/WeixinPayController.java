package com.icoffee.weixin.pay.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icoffee.weixin.mp.service.IWeixinMpService;
import com.icoffee.weixin.pay.service.IUnifiedOrderRequest;
import com.icoffee.weixin.pay.service.WeixinPayRequest;

@Controller
@RequestMapping("/pay")
public class WeixinPayController {
	@Autowired
	@Qualifier("weixinMpService")
	IWeixinMpService weixinMpService;
	
	@RequestMapping(value="/aaaaaaaaaaa")
	public void createQrcode() {
		IUnifiedOrderRequest request = new WeixinPayRequest();
		request.setAppid(weixinMpService.getWeixinAppid());
		request.setMch_id(weixinMpService.getWeixinPayMchid());
		request.setDevice_info("deviceinfo");
		long rand = System.nanoTime();
		request.setNonce_str(Long.toHexString(rand));
		request.setBody("你大爷的， 我这是一个测试");
		request.setOut_trade_no("" + rand);
		request.setTotal_fee(1);   // ￥0.01
		request.setSpbill_create_ip("172.16.36.19");
		request.setNotify_url("http://www.icoffee-tech.com/icoffee/pay/notify");
		request.setTrade_type("NATIVE");
		
	}
}
