package com.spring.config.taglib.form_control;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.jsp.tagext.TagSupport;

import com.spring.config.annotation.form_control.Select;
import com.spring.config.taglib.form.FormTag;

public class SelectTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doTag() throws IOException {
		pageContext.getOut().println("<field-box>");
		pageContext.getOut().println("   <label>"+label()+"</label>");
		pageContext.getOut().println("   <select name=\""+name()+"\" class=\"form-control\">");
		pageContext.getOut().println("   </select>");
		pageContext.getOut().println("</field-box>");
	}
	
	public int index() {
		return (Integer) pageContext.findAttribute("index");
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
		Object object = pageContext.findAttribute("command");
		return object.getClass().getMethod("get"+caps(field().getName())).invoke(object);
	}
	
	private String caps(String string) {
		char[] charArray = string.toCharArray();
		charArray[0] = Character.toUpperCase(charArray[0]);
		String Key = new String(charArray);
		return Key;
	}
	
}
