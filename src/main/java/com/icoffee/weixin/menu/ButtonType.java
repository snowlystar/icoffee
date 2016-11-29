package com.icoffee.weixin.menu;

public enum ButtonType {
	click("click"), view("view"), scancode_push("scancode_push"), 
	scancode_waitmsg("scancode_waitmsg"), pic_sysphoto("pic_sysphoto"),
	pic_weixin("pic_weixin"), location_select("location_select");
	
	private String text;
	
	
	ButtonType(String value) {
		this.text = value;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
