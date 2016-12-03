package com.icoffee.weixin.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/weixin")
public class WeixinController {
	@Autowired
	@Qualifier("weixinMessageCastorMarshaller")
	private Marshaller marshaller;
	
	@Autowired
	@Qualifier("weixinMessageCastorMarshaller")	
	private Unmarshaller unmarshaller;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(method=RequestMethod.GET,params={"signature", "timestamp", "nonce", "echostr"})
	public void weixinHandler(HttpServletRequest request, 
			HttpServletResponse response, 
			@RequestParam("signature")String signature, 
			@RequestParam("timestamp")String timestamp,
			@RequestParam("nonce")String nonce,
			@RequestParam("echostr")String echostr) throws IOException, NoSuchAlgorithmException {
		
		String [] params = new String[] {"hellolixiaojing", timestamp, nonce};
		Arrays.sort(params);
		StringBuffer sb = new StringBuffer(params[0]).append(params[1]).append(params[2]);
		MessageDigest dm = MessageDigest.getInstance("SHA1");
		byte[] sigdata = dm.digest(sb.toString().getBytes());
		StringBuffer sigresult = new StringBuffer();
		for (byte b : sigdata) {
			int i = 0x0ff & b;
			if(i<=0xf) {
				sigresult.append(0);
			}
			sigresult.append(Integer.toHexString(i));
		}
		if (signature.equalsIgnoreCase(sigresult.toString())) {
			PrintWriter out = response.getWriter();
			out.print(echostr);
			out.close();
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void messageHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream is = request.getInputStream();
		WeixinMessage msg = (WeixinMessage)unmarshaller.unmarshal(new StreamSource(is));
		is.close();
		
		System.out.println(msg.getFromUserName());
		
		// messageStore.append(msg);
		response.getWriter().println("success");
	}
}
