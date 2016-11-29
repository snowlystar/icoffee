package com.icoffee.weixin.menu;

import com.google.gson.Gson;

public class MenuToJsonTest {

	public static void main(String[] args) {
		WeixinMenu weixinMenu = new WeixinMenu();
		Button [] topMenus = new Button[3];
		
		ClickButton clickButton = new ClickButton("我的消费", "view_my_orders");
		topMenus[0] = clickButton;
		
		ViewButton website = new ViewButton("微官网", "www.icoffee-tech.com");
		topMenus[1] = website;
		
		topMenus[2] = website;
		
		weixinMenu.setButton(topMenus);
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(weixinMenu));
		
	}

}
