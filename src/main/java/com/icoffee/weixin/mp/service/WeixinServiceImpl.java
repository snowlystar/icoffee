package com.icoffee.weixin.mp.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.icoffee.weixin.material.MaterialCount;
import com.icoffee.weixin.material.MaterialItem;
import com.icoffee.weixin.material.MaterialQueryResult;
import com.icoffee.weixin.material.MaterialType;
import com.icoffee.weixin.material.NewsMaterialItem;
import com.icoffee.weixin.menu.Button;
import com.icoffee.weixin.menu.ClickButton;
import com.icoffee.weixin.menu.ViewButton;
import com.icoffee.weixin.menu.WeixinMenu;

@Scope("singleton")
@Component("weixinService")
public class WeixinServiceImpl implements IWeixinService {
	RestTemplate restTemplate = new RestTemplate();

	//
	WeixinToken currentToken;

	@Override
	public WeixinToken refreshToken(String appid, String secret) {
		String returnstring = restTemplate.getForObject(
				"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}",
				String.class, appid, secret);
		Gson gson = new Gson();
		WeixinToken token = gson.fromJson(returnstring, WeixinToken.class);
		currentToken = token;
		return token;
	}

	@Override
	public String getToken() {
		if (currentToken == null) {
			return null;
		}
		if (currentToken.isExpired()) {
			return null;
		} else {
			return currentToken.getAccess_token();
		}
	}

	/**
	 * generate json to create weixin menu
	 * 
	 * @return
	 */
	private String getCreateMenuJson() {
		WeixinMenu weixinMenu = new WeixinMenu();
		Button[] topMenus = new Button[3];

		ClickButton clickButton = new ClickButton("°®¿§·È", "weixin_menu_AboutUs");
		topMenus[0] = clickButton;

		ViewButton website = new ViewButton("Î¢¹ÙÍø", "http://www.icoffee-tech.com");
		topMenus[1] = website;

		topMenus[2] = website;

		weixinMenu.setButton(topMenus);

		Gson gson = new Gson();
		return gson.toJson(weixinMenu);
	}

	RestResponse errorRestResponse(String msg) {
		RestResponse result = new RestResponse();
		result.setErrcode("ICOFFEE_CUSTOM_CODE");
		result.setErrmsg(msg);
		return result;
	}

	private Object jsonStream2object(InputStream is, Class<?> clasz) throws UnsupportedEncodingException, IOException {
		if (is.available() > 0) {
			byte[] data = new byte[is.available()];
			is.read(data);
			String json = new String(data, "UTF-8");
			return new Gson().fromJson(json, clasz);

		} else {
			return null;
		}
	}
	
	private Object jsonStream2object(InputStream is, Type type) throws UnsupportedEncodingException, IOException {
		if (is.available() > 0) {
			byte[] data = new byte[is.available()];
			is.read(data);
			String json = new String(data, "UTF-8");
			return new Gson().fromJson(json, type);

		} else {
			return null;
		}
	}

	@Override
	public RestResponse createMenu() {
		String accessToken = getToken();
		if (accessToken == null) {
			return errorRestResponse("Invalid weixin token");
		}

		final String menuJson = getCreateMenuJson();
		return restTemplate.execute("https://api.weixin.qq.com/cgi-bin/menu/create?access_token={token}",
				HttpMethod.POST, new RequestCallback() {
					@Override
					public void doWithRequest(ClientHttpRequest request) throws IOException {
						OutputStream os = request.getBody();
						os.write(menuJson.getBytes("UTF-8"));
						os.close();
					}
				},

				new ResponseExtractor<RestResponse>() {
					@Override
					public RestResponse extractData(ClientHttpResponse response) throws IOException {
						InputStream is = response.getBody();
						return (RestResponse) jsonStream2object(is, RestResponse.class);
					}
				}, accessToken);

	}

	@Override
	public RestResponse deleteCreateMenu() {
		String token = getToken();
		RestResponse result = restTemplate.execute("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token={0}",
				HttpMethod.POST, new RequestCallback() {
					@Override
					public void doWithRequest(ClientHttpRequest request) throws IOException {
					}
				}, new ResponseExtractor<RestResponse>() {
					@Override
					public RestResponse extractData(ClientHttpResponse response) throws IOException {
						if (response.getRawStatusCode() == 200) {
							Gson gson = new Gson();
							RestResponse result = gson.fromJson(new InputStreamReader(response.getBody(), "UTF-8"),
									RestResponse.class);
							return result;
						} else {
							RestResponse result = errorRestResponse("weixin server error");
							return result;
						}
					}
				}, token);
		return result;
	}

	/**
	 * query material count, group by material type see MaterialCount
	 * 
	 * @return
	 */
	public MaterialCount queryMaterialCount() {
		final String token = getToken();
		return restTemplate.execute("https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token={0}",
				HttpMethod.GET, null, new ResponseExtractor<MaterialCount>() {
					@Override
					public MaterialCount extractData(ClientHttpResponse response) throws IOException {
						InputStream is = response.getBody();
						MaterialCount count = (MaterialCount) jsonStream2object(is, MaterialCount.class);
						return count;
					}
				}, token);
	}

	@Override
	public List<MaterialItem> queryMaterials(MaterialType type, int skip, int maxResults) {
		final int _maxResult = 20;

		final String token = getToken();
		List<MaterialItem> ret = new ArrayList<>();
		while (ret.size() < maxResults) {
			StringBuffer conditionJson = new StringBuffer();
			conditionJson.append("{\n");
			conditionJson.append("\"type\":\"").append(type.toString()).append("\",\n");
			conditionJson.append("\"offset\":").append(ret.size()).append(",\n");
			conditionJson.append("\"count\":").append(_maxResult).append("\n");
			conditionJson.append("}");
			final String condition = conditionJson.toString();
			RequestCallback requestcallback = new RequestCallback() {
				@Override
				public void doWithRequest(ClientHttpRequest request) throws IOException {
					request.getBody().write(condition.toString().getBytes("UTF-8"));
				}
			};

			int item_count = -1;
			MaterialItem[] items = null;

			final Type tokenType;
			if (type.equals(MaterialType.NEWS)) {
				tokenType = new  TypeToken<MaterialQueryResult<NewsMaterialItem>>(){}.getType();
			}
			else {
				tokenType = new  TypeToken<MaterialQueryResult<MaterialItem>>(){}.getType();
			}

			ResponseExtractor<MaterialQueryResult<MaterialItem>> responseExtractor = new ResponseExtractor<MaterialQueryResult<MaterialItem>>() {
				@SuppressWarnings("unchecked")
				@Override
				public MaterialQueryResult<MaterialItem> extractData(ClientHttpResponse response) throws IOException {
					return (MaterialQueryResult<MaterialItem>) jsonStream2object(response.getBody(), tokenType);
				}
			};

			// weixin api limits the max results returned once. The number
			// is 20
			MaterialQueryResult<? extends MaterialItem> queryResult = (MaterialQueryResult<? extends MaterialItem>) restTemplate
					.execute("https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token={0}",
							HttpMethod.POST, requestcallback, responseExtractor, token);
			item_count = queryResult.getItem_count();
			items = queryResult.getItem();

			if (item_count > 0) {
				for (MaterialItem item : items) {
					item.setMaterialType(type);
					ret.add(item);
				}
				if (item_count < _maxResult) {
					break;
				}
			} else {
				break;
			}
		}

		return ret;
	}
}
