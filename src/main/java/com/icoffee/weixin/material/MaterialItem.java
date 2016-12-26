package com.icoffee.weixin.material;

public class MaterialItem {
	private MaterialType materialType;
	
	private String media_id, name, update_time, url;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MaterialType getMaterialType() {
		return materialType;
	}

	public void setMaterialType(MaterialType materialType) {
		this.materialType = materialType;
	}

	@Override
	public String toString() {
		return "\nMaterialItem [materialType=" + materialType + ", media_id=" + media_id + ", name=" + name
				+ ", update_time=" + update_time + ", url=" + url + "]\n";
	}
}
