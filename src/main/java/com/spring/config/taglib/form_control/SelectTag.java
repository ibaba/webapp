package com.spring.config.taglib.form_control;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.spring.config.annotation.form_control.Select;
import com.spring.config.taglib.form.FormTag;

public class SelectTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		JspWriter out = pageContext.getOut();
		pageContext.setAttribute("select_classe", classe());
		try {
			out.println("<field-box>");
			
			out.println("   <label>"+label()+"</label>");
			if(field().getType() == List.class || field().getType() == ArrayList.class )
				out.println("   <select name=\""+name()+"\" multiple=\"multiple\" class=\"form-control\">");
			else
				out.println("   <select name=\""+name()+"\" class=\"form-control\">");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() {
		JspWriter out = pageContext.getOut();
		try {
			out.println("   </select>");
			out.println("</field-box>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
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
	
	public List<?> value() throws Exception {
		Object object = pageContext.findAttribute("command");
		return (List<?>) object.getClass().getMethod("get"+caps(field().getName())).invoke(object);
	}
	
	private String caps(String string) {
		char[] charArray = string.toCharArray();
		charArray[0] = Character.toUpperCase(charArray[0]);
		String Key = new String(charArray);
		return Key;
	}
	
}
