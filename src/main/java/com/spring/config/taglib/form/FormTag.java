package com.spring.config.taglib.form;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.spring.config.annotation.form.Form;

public class FormTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int doStartTag() {
		JspWriter out = pageContext.getOut();
		try {
			String action = new String();
			Object command = pageContext.findAttribute("command");
			Integer id = (Integer) command.getClass().getMethod("getId").invoke(command); 
			if(id == null) {
				action = pageContext.getServletContext().getContextPath() + "/" + classe().getSimpleName() + "/insert";
				out.println("<form class=\"form\" role=\"form\" method=\"post\" action=\""+action+"\">");
			}
			else {
				action = pageContext.getServletContext().getContextPath() + "/" + classe().getSimpleName() + "/update";
				out.println("<form class=\"form\" role=\"form\" method=\"post\" action=\""+action+"\">");
				out.println("   <input type=\"hidden\" name=\"id\" value=\""+id+"\"/>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();
			out.println("</form>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	public Class<?> classe() {
		return pageContext.findAttribute("command").getClass().getAnnotation(Form.class).classe();
	}
	
	public List<Field> fields() {
		return Arrays.asList(classe().getDeclaredFields());
	}

}
