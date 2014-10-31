package com.spring.config.taglib.form_control;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.spring.config.annotation.form_control.Select;
import com.spring.config.taglib.form.FormTag;

public class SelectTag extends SimpleTagSupport {
	
	public void doTag() throws IOException {
		getJspContext().getOut().println("<field-box>");
		getJspContext().getOut().println("   <label>"+label()+"</label>");
		getJspContext().getOut().println("   <select name=\""+name()+"\" class=\"form-control\">");
		getJspContext().getOut().println("   </select>");
		getJspContext().getOut().println("</field-box>");
	}
	
	public int index() {
		return (Integer) getJspContext().findAttribute("index");
	}
	
	public Field field() {
		FormTag tag = (FormTag) findAncestorWithClass(this, FormTag.class);
		return tag.fields().get(index());
	}
	
	public Class<?> classe() {
		return field().getAnnotation(Select.class).classe();
	}
	
	public String label() {
		return field().getAnnotation(Select.class).label();
	}
	
	public String name() {
		return field().getName();
	}
	
	public Object value() throws Exception {
		Object object = getJspContext().findAttribute("command");
		return object.getClass().getMethod("get"+field().getName()).invoke(object);
	}
	
}
