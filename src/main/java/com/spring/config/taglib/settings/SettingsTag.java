package com.spring.config.taglib.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SettingsTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;
	
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

	private String value() throws Exception {
		Properties props = new Properties();
		
		File file = new File( getFilename() );
		if( file.exists() ) {
			FileInputStream fos = new FileInputStream( getFilename() );
			props.load(fos);
			fos.close();
		} else {
			FileOutputStream fos = new FileOutputStream( getFilename() );
			props.store(fos, "settings");
			fos.close();
		}
		
		return props.getProperty(key);
	}
	
	private String getFilename() {
		return System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences";
	}

}
