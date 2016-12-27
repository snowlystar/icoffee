package com.icoffee.weixin.pay.service;

public interface WeixinPayService {
	IUnifiedOrderResponse createUnifiedOrder(IUnifiedOrderRequest request);
}
