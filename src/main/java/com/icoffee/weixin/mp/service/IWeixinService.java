package com.icoffee.weixin.mp.service;

import java.util.List;

import com.icoffee.weixin.material.MaterialCount;
import com.icoffee.weixin.material.MaterialItem;
import com.icoffee.weixin.material.MaterialType;

public interface IWeixinService {
	/**
	 * Ë¢ÐÂtoken and store the token into cache
	 * @return
	 */
	WeixinToken refreshToken(String appid, String secret);
	
	/**
	 * get token from cache.
	 * if get null, call refreshToken to get a new one.
	 * @return
	 */
	String getToken();

	/**
	 * create weinxin menu
	 * @return
	 */
	RestResponse createMenu();
	
	/**
	 * delete weixin menu
	 * @return
	 */
	RestResponse deleteCreateMenu();
	
	/**
	 * query material count, group by material type
	 * see MaterialCount
	 * 
	 * @return
	 */
	public MaterialCount queryMaterialCount();
	
	/**
	 * a pageble query method
	 * 
	 * @param type
	 * @param skip
	 * @param maxResults
	 * @return
	 */
	public List<MaterialItem> queryMaterials(MaterialType type, int skip, int maxResults);
}
