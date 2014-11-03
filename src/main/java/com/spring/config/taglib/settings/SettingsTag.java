package com.spring.config.taglib.settings;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SettingsTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;
	
	private String value;
	
	public int doStartTag() {
		JspWriter out = pageContext.getOut();
		try {
			out.print(value());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() {
		JspWriter out = pageContext.getOut();
		try {
			out.print("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
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
