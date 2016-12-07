package com.icoffee.weixin.mp.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.icoffee.weixin.material.MaterialCount;
import com.icoffee.weixin.material.MaterialItem;
import com.icoffee.weixin.material.MaterialType;
import com.icoffee.weixin.mp.service.IWeixinService;
import com.icoffee.weixin.mp.service.RestResponse;

@Controller
@RequestMapping("/admin")
public class AdminController {
	RestTemplate restTemplate = new RestTemplate();

	@Autowired(required=true)
	@Qualifier("weixinService")
	private IWeixinService weixinService;

	@RequestMapping(value="/createMenu")
	public void createMenu(HttpServletResponse response) throws IOException {
		RestResponse result = weixinService.createMenu();
		
		PrintWriter out = response.getWriter();
		out.println(result.getErrmsg());
		out.close();
	}
	
	@RequestMapping(value="/deleteMenu")
	public void deleteMenu(HttpServletResponse response) throws IOException {
		RestResponse result = weixinService.deleteCreateMenu();
		response.getWriter().write(result.getErrmsg());
	}
	
	@RequestMapping(value="/queryMaterial")
	public void queryResource(HttpServletResponse response) throws IOException {
		response.setContentType("text/plain; charset=UTF-8");
		MaterialCount count = weixinService.queryMaterialCount();
		PrintWriter out = response.getWriter();
		out.println(count);
		
		// for each material type, query all materials
		List<MaterialItem> ret = new ArrayList<>();
		if (count.getImage_count() > 0) {
			ret.addAll(weixinService.queryMaterials(MaterialType.IMAGE, 0, count.getImage_count()));
		}
		
		if (count.getNews_count() > 0) {
			ret.addAll(weixinService.queryMaterials(MaterialType.NEWS, 0, count.getNews_count()));
		}
		
		if (count.getVideo_count() > 0) {
			ret.addAll(weixinService.queryMaterials(MaterialType.VIDEO, 0, count.getVideo_count()));
		}
		
		if (count.getVoice_count() > 0) {
			ret.addAll(weixinService.queryMaterials(MaterialType.VOICE, 0, count.getVoice_count()));
		}
		
		out.println(ret);
	}
}
