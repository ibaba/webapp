package com.spring.config.taglib.form;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.JspWriter;

public class FormSettingsTag extends FormTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String classe;
	
	public int doStartTag() {
		JspWriter out = pageContext.getOut();
		try {
			pageContext.setAttribute("command", classe().newInstance());
			File file = new File( getFilename() );
			String action;
			if(file.exists())
				if(pageContext.findAttribute("action") == null)
					action = pageContext.getServletContext().getContextPath() + "/" + classe().getSimpleName() + "/update";
				else
					action = pageContext.getServletContext().getContextPath() + "/" + classe().getSimpleName() + "/delete";
			else
				action = pageContext.getServletContext().getContextPath() + "/" + classe().getSimpleName() + "/create";
			
			out.println("<form id=\"command\" class=\"form\" role=\"form\" method=\"post\" action=\""+action+"\">");
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
	
	public Class<?> classe() {
		try {
			return Class.forName("com.spring.model.settings."+getClasse().toLowerCase()+"."+getClasse());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Field> fields() {
		return Arrays.asList(classe().getDeclaredFields());
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	private String getFilename() {
		return System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences";
	}

}
