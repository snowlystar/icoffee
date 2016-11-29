package com.icoffee.weixin.menu;

public class ViewButton extends AbstractButton {
	private String url;

	public ViewButton(String name, String url) {
		setType(ButtonType.view);
		setName(name);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
