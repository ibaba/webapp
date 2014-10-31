package com.spring.config.taglib.form_control;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.spring.config.annotation.form_control.DataList;
import com.spring.config.taglib.form.FormTag;

public class DataListTag extends SimpleTagSupport {
	
	public void doTag() throws IOException {
		getJspContext().getOut().println("<field-box>");
		getJspContext().getOut().println("   <label>"+label()+"</label>");
		try {
			getJspContext().getOut().println("   <input name=\""+name()+"\" value=\""+value()+"\" list=\""+name()+"\" class=\"form-control\"/>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		getJspContext().getOut().println("   <datalist id=\""+name()+"\">");
		getJspContext().getOut().println("   </datalist>");
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
		return field().getAnnotation(DataList.class).classe();
	}
	
	public String label() {
		return field().getAnnotation(DataList.class).label();
	}
	
	public String name() {
		return field().getName();
	}
	
	public Object value() throws Exception {
		Object object = getJspContext().findAttribute("command");
		return object.getClass().getMethod("get"+caps(field().getName())).invoke(object);
	}
	
	private String caps(String string) {
		char[] charArray = string.toCharArray();
		charArray[0] = Character.toUpperCase(charArray[0]);
		String Key = new String(charArray);
		return Key;
	}
	
}
