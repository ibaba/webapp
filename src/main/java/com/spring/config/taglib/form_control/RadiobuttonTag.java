package com.spring.config.taglib.form_control;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.spring.config.annotation.form_control.Radiobutton;
import com.spring.config.taglib.form.FormTag;

public class RadiobuttonTag extends SimpleTagSupport {

	public void doTag() throws IOException {
		getJspContext().getOut().println("<field-box>");
		try {
			if(value())
				getJspContext().getOut().println("   <input type=\"radio\" name=\""+name()+"\" checked=\"checked\">"+label()+"<br>");
			else
				getJspContext().getOut().println("   <input type=\"radio\" name=\""+name()+"\">"+label()+"<br>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		getJspContext().getOut().println("</field-box>");
	}
	
	public int index() {
		return (Integer) getJspContext().findAttribute("index");
	}
	
	public Field field() {
		FormTag tag = (FormTag) findAncestorWithClass(this, FormTag.class);
		return tag.fields().get(index());
	}
	
	public String label() {
		return field().getAnnotation(Radiobutton.class).label();
	}
	
	public String name() {
		return field().getName();
	}
	
	public Boolean value() throws Exception {
		Object object = getJspContext().findAttribute("command");
		return (Boolean) object.getClass().getMethod("get"+field().getName()).invoke(object);
	}
	
}
