package com.icoffee.weixin.menu;

public class ClickButton extends AbstractButton {
	private String key;
	
	public ClickButton(String name, String key) {
		setType(ButtonType.click);
		setName(name);
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
