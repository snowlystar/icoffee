package com.icoffee.weixin.admin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.icoffee.weixin.menu.Button;
import com.icoffee.weixin.menu.ClickButton;
import com.icoffee.weixin.menu.ViewButton;
import com.icoffee.weixin.menu.WeixinMenu;
import com.icoffee.weixin.mp.service.IWeixinService;

@Controller
@RequestMapping("/test")
public class TestController {
	RestTemplate restTemplate = new RestTemplate();

	@Autowired(required=true)
	@Qualifier("weixinService")
	private IWeixinService weixinService;

	@RequestMapping(value="/createMenu")
	public void createMenu(HttpServletResponse response) throws IOException {
		final String menuJdon = getCreateMenuJson();
		String accessToken = weixinService.getToken();
		if(accessToken == null) {
			return;
		}

		String result = restTemplate.execute("https://api.weixin.qq.com/cgi-bin/menu/create?access_token={token}", HttpMethod.POST,
				new RequestCallback() {
					@Override
					public void doWithRequest(ClientHttpRequest request) throws IOException {
						OutputStream os = request.getBody();
						os.write(menuJdon.getBytes("UTF-8"));
						os.close();
					}
				},

				new ResponseExtractor<String>() {
					@Override
					public String extractData(ClientHttpResponse response) throws IOException {
						InputStream is = response.getBody();
						if (is.available()>0) {
							byte[] data = new byte[is.available()];
							is.read(data);
							return new String(data, "UTF-8");
						}
						else {
							return "";
						}
					}
				}, 
				accessToken);
		
		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();
	}

	private String getCreateMenuJson() {
		WeixinMenu weixinMenu = new WeixinMenu();
		Button[] topMenus = new Button[3];

		ClickButton clickButton = new ClickButton("我的消费", "view_my_orders");
		topMenus[0] = clickButton;

		ViewButton website = new ViewButton("微官网", "http://www.icoffee-tech.com");
		topMenus[1] = website;

		topMenus[2] = website;

		weixinMenu.setButton(topMenus);

		Gson gson = new Gson();
		return gson.toJson(weixinMenu);
	}
	
	@RequestMapping(value="/message")
	void testMessage(HttpServletResponse response, @RequestParam("xml") String xml) throws IOException {
		byte[] data = xml.getBytes("UTF-8");
		String result = restTemplate.postForObject("http://localhost:8080/icoffee/weixin", data, String.class);
		response.getWriter().println(result);
	}
}
