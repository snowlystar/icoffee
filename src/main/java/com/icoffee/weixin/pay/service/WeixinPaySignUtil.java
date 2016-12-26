package com.icoffee.weixin.pay.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Sign a object
 * @author lixiaojing
 *
 */
public class WeixinPaySignUtil {
	public List<String> findPropertyNames(Object msg) throws NoSuchMethodException, SecurityException {
		List<String> ret = new ArrayList<>();
		
		Method[] allmethods = msg.getClass().getMethods();
		// for each getXXXX() method , if there is a method setXXX(parameter type), then we consider xxx as a propertyName.
		for (Method m : allmethods) {
			if (m.getParameterCount()==0 && m.getName().startsWith("get")) {
				StringBuffer methodName = new StringBuffer(m.getName());
				methodName.delete(0, 3);  // delete prefix 'get'
				if (Character.isUpperCase(methodName.charAt(0))) {
					Class<?>  returntype = m.getReturnType();
					try {
						// search a method that the name is set<propertyName> and the parameter type is returntype;
						Method setter = msg.getClass().getDeclaredMethod("set" + methodName.toString(), returntype);
						if (setter != null) {
							methodName.setCharAt(0, Character.toLowerCase(methodName.charAt(0)));
							String propertyName = methodName.toString();		// it is a propertyName.
							ret.add(propertyName);
						}
					}
					catch (NoSuchMethodException e) {
						// ignore;
					}
					
				}
			}
		}

		// sort
		ret.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		return ret;
	}
	
	Object getValue(Object msg, String key) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method method = getGetter(msg, key);
		Object value = method.invoke(msg);
		return value;
	}
	
	String getSignResult(Object msg) {
		return null;
	}
	
	private Method getGetter(Object msg, String propertyName) throws NoSuchMethodException, SecurityException {
		// getter's name
		StringBuffer sb = new StringBuffer(propertyName);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		sb.insert(0, "get");

		return msg.getClass().getMethod(sb.toString());
	}
}
