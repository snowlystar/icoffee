package com.icoffee.weixin.material;

public enum MaterialType {
	VOICE("voice"), VIDEO("video"), NEWS("news"), IMAGE("image");
	
	private String typeName;
	
	MaterialType(String typeName) {
		this.typeName = typeName;
	}
	
	public String toString() {
		return typeName;
	}
}
