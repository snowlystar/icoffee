package com.icoffee.weixin.admin;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.icoffee.weixin.material.MaterialItem;
import com.icoffee.weixin.material.MaterialQueryResult;

public class GsonTest {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		MaterialQueryResult<MaterialItem>  queryReuslt = new MaterialQueryResult<>();
		queryReuslt.setItem_count(5);
		queryReuslt.setTotal_count(5);
		
		MaterialItem[]  items = new MaterialItem[1];
		MaterialItem item = new MaterialItem();
		item.setMedia_id("media_id");
		item.setName("name");
		item.setUpdate_time("update_time");
		item.setUrl("url");
		items[0] = item;
		
		queryReuslt.setItem(items);
		

		String json = gson.toJson(queryReuslt);
		Type type = new  TypeToken<MaterialQueryResult<MaterialItem>>(){}.getType();
		
		@SuppressWarnings("unchecked")
		MaterialQueryResult<MaterialItem>  newresult = (MaterialQueryResult<MaterialItem>)gson.fromJson(json, type);
		
		System.out.println(newresult);
		
	}

}
