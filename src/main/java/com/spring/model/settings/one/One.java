package com.spring.model.settings.one;

import java.util.Properties;

import com.spring.config.annotation.form.FormSettings;
import com.spring.config.annotation.form_control.Input;

@FormSettings
public class One extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Input(label = "One")
	private String one;
	
	@Input(label = "Two")
	private String two;
	
	@Input(label = "Three")
	private String three;
	
	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}
	

}
