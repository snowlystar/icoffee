package com.icoffee.weixin.pay.service;

public interface IUnifiedOrderRequest {

	String getAppid();

	void setAppid(String appid);

	String getMch_id();

	void setMch_id(String mch_id);

	String getDevice_info();

	void setDevice_info(String device_info);

	String getNonce_str();

	void setNonce_str(String nonce_str);

	String getSign();

	void setSign(String sign);

	String getSign_type();

	void setSign_type(String sign_type);

	String getBody();

	void setBody(String body);

	String getDetail();

	void setDetail(String detail);

	String getAttach();

	void setAttach(String attach);

	String getOut_trade_no();

	void setOut_trade_no(String out_trade_no);

	String getFee_type();

	void setFee_type(String fee_type);

	Integer getTotal_fee();

	void setTotal_fee(Integer total_fee);

	String getSpbill_create_ip();

	void setSpbill_create_ip(String spbill_create_ip);

	String getTime_start();

	void setTime_start(String time_start);

	String getTime_expire();

	void setTime_expire(String time_expire);

	String getGoods_tag();

	void setGoods_tag(String goods_tag);

	String getNotify_url();

	void setNotify_url(String notify_url);

	String getTrade_type();

	void setTrade_type(String trade_type);

	String getProduct_id();

	void setProduct_id(String product_id);

	String getLimit_pay();

	void setLimit_pay(String limit_pay);

	String getOpenid();

	void setOpenid(String openid);

}