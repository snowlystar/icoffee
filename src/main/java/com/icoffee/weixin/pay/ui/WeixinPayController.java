package com.icoffee.weixin.pay.ui;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icoffee.weixin.mp.service.IWeixinMpService;
import com.icoffee.weixin.pay.service.IUnifiedOrderRequest;
import com.icoffee.weixin.pay.service.IUnifiedOrderResponse;
import com.icoffee.weixin.pay.service.WeixinPayRequest;
import com.icoffee.weixin.pay.service.WeixinPayService;
import com.icoffee.weixin.pay.service.WeixinPaySignUtil;

@Controller
@RequestMapping("/pay")
public class WeixinPayController {
	private WeixinPaySignUtil signUtil = new WeixinPaySignUtil(); 
	
	@Autowired
	@Qualifier("weixinPayService")
	private WeixinPayService WeixinPayService;
	
	@Autowired
	@Qualifier("weixinMpService")
	IWeixinMpService weixinMpService;
	
	@RequestMapping(value="/a", method=RequestMethod.GET)
	public void createQrcode() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchAlgorithmException, UnsupportedEncodingException {
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
		request.setProduct_id("thefirstproductid");
		
		IUnifiedOrderResponse response = WeixinPayService.createUnifiedOrder(request);
		System.out.println(response);
	}
}
