package com.icoffee.weixin.pay.service;

public interface IUnifiedOrderResponse {

	String getReturn_code();

	void setReturn_code(String return_code);

	String getReturn_msg();

	void setReturn_msg(String return_msg);

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

	String getResult_code();

	void setResult_code(String result_code);

	String getErr_code();

	void setErr_code(String err_code);

	String getErr_code_des();

	void setErr_code_des(String err_code_des);

	String getTrade_type();

	void setTrade_type(String trade_type);

	String getPrepay_id();

	void setPrepay_id(String prepay_id);

	String getCode_url();

	void setCode_url(String code_url);

}