package com.spring.config.taglib.form;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.spring.config.annotation.form.Form;
import com.spring.config.annotation.form_control.Checkbox;
import com.spring.config.annotation.form_control.DataList;
import com.spring.config.annotation.form_control.Input;
import com.spring.config.annotation.form_control.Radiobutton;
import com.spring.config.annotation.form_control.Select;
import com.spring.config.annotation.form_control.Textarea;

public class FormTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int doStartTag() {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<form>");
		} catch (IOException e) {
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
		List<Field> lista = new ArrayList<Field>();
		
		Field fields[] = classe().getDeclaredFields();
		for(int i=0; i<fields.length; i++)
			for(int j=0; j<annotations().size(); j++)
				if(fields[i].isAnnotationPresent(annotations().get(j)))
					lista.add(fields[i]);
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Class<? extends Annotation>> annotations() {
		return Arrays.asList(Checkbox.class, DataList.class, Input.class, Radiobutton.class, Select.class, Textarea.class);
	}

}
