package com.spring.model.settings.one;

import org.springframework.beans.factory.annotation.Value;

import com.spring.config.annotation.form.FormSettings;
import com.spring.config.annotation.form_control.Input;
import com.spring.config.annotation.settings.Property;
import com.spring.config.generic.persistence.Settings;

@FormSettings
public class One extends Settings {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Input(label = "One")
	@Property(key = "one.one")
	@Value(value = "${one.one}")
	private String one;
	
	@Input(label = "Two")
	@Property(key = "one.two")
	@Value(value = "${one.two}")
	private String two;
	
	@Input(label = "Three")
	@Property(key = "one.three")
	@Value(value = "${one.three}")
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

	@Override
	public String toString() {
		return "{"+one+", "+two+", "+three+"}";
	}
	

}
