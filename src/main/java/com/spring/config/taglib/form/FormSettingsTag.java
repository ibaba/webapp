package com.spring.config.taglib.form;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class FormSettingsTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String classe;
	
	public int doStartTag() {
		JspWriter out = pageContext.getOut();
		try {
			String action = pageContext.getServletContext().getContextPath() + "/" + classe().getSimpleName() + "/update";
			out.println("<form class=\"form\" role=\"form\" method=\"post\" action=\""+action+"\">");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() {
		JspWriter out = pageContext.getOut();
		try {
			out.println("</form>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	public Class<?> classe() throws Exception {
		return Class.forName("com.spring.model.settings."+getClasse().toLowerCase()+"."+getClasse());
	}
	
	public List<Field> fields() throws Exception {
		return Arrays.asList(classe().getDeclaredFields());
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

}
