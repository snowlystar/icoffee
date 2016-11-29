package com.icoffee.weixin.menu;

public abstract class AbstractButton implements Button {
	private String name;
	private ButtonType type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ButtonType getType() {
		return type;
	}
	public void setType(ButtonType type) {
		this.type = type;
	}
}
