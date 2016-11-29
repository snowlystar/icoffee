package com.icoffee.weixin.menu;

public class SubMenu implements Button {
	private String name;
	AbstractButton[] sub_button;
	
	public SubMenu(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AbstractButton[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(AbstractButton[] sub_button) {
		this.sub_button = sub_button;
	}
}
