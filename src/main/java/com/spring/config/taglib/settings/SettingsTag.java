package com.spring.config.taglib.settings;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SettingsTag extends SimpleTagSupport {

	private String key;
	
	private String value;
	
	public void doTag() {
		JspWriter out = getJspContext().getOut();
		try {
			out.println(value());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	private String value() throws Exception {
		Properties props = new Properties();
		
		String attr = key+"."+value;
		String filename = System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences";
		FileInputStream fos = new FileInputStream( filename );
		props.load(fos);
		fos.close();
		
		return props.getProperty(attr);
	}

}
