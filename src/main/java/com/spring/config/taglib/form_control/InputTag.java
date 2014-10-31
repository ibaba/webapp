package com.spring.config.taglib.form_control;

import java.io.IOException;
import java.lang.reflect.Field;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.spring.config.annotation.form_control.Input;
import com.spring.config.taglib.form.FormTag;

public class InputTag extends SimpleTagSupport {

	public void doTag() throws IOException {
		getJspContext().getOut().println("<field-box>");
		getJspContext().getOut().println("   <label>"+label()+"</label>");
		try {
			getJspContext().getOut().println("   <input type=\""+type()+"\" name=\""+name()+"\" value=\""+value()+"\" pattern=\""+pattern()+"\" class=\"form-control\"/>");
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
	
	public String type() {
		return field().getAnnotation(Input.class).type();
	}
	
	
	public String pattern() {
		return field().getAnnotation(Input.class).pattern();
	}
	
	public String label() {
		return field().getAnnotation(Input.class).label();
	}
	
	public String name() {
		return field().getName();
	}
	
	public Object value() throws Exception {
		Object object = getJspContext().findAttribute("command");
		return object.getClass().getMethod("get"+field().getName()).invoke(object);
	}
	
}
