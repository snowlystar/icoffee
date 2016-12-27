package com.icoffee.weixin.pay.service;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

public class WeixinPayServiceImpl implements WeixinPayService {
	private WeixinPaySignUtil signUtil = new WeixinPaySignUtil();
	RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	@Qualifier("weixinPayMessageCastorMarshaller")
	private Marshaller marshaller;

	@Autowired
	@Qualifier("weixinPayMessageCastorMarshaller")
	private Unmarshaller unmarshaller;
	
	private static final String URL_UNIFIED_ORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	@Override
	public IUnifiedOrderResponse createUnifiedOrder(IUnifiedOrderRequest request) {
		try {
			String md5 = signUtil.getSignResult(request, "aaaaaaa");
			request.setSign(md5);
			
			final StringWriter writer = new StringWriter();
			Result xmlresult = new StreamResult(writer);
			marshaller.marshal(request, xmlresult);
			return restTemplate.execute(URL_UNIFIED_ORDER, HttpMethod.POST, new RequestCallback() {
				@Override
				public void doWithRequest(ClientHttpRequest request) throws IOException {
					request.getBody().write(writer.toString().getBytes("UTF-8"));
				}
			}, 
			new ResponseExtractor<IUnifiedOrderResponse>() {
				@Override
				public IUnifiedOrderResponse extractData(ClientHttpResponse response) throws IOException {
					IUnifiedOrderResponse retmessage = (IUnifiedOrderResponse)unmarshaller.unmarshal(new StreamSource(response.getBody()));
					return retmessage;
				}
			});
			
		}
		catch(Exception e) {
			return null;
		}
	}
}
