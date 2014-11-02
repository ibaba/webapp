package com.spring.config.taglib.form_control;

import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class OptionsTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int doStartTag() {
		JspWriter out = pageContext.getOut();
		try {
			List<?> lista = list_values();
			if(lista != null) {
				for(Object object:lista) {
					Integer id = (Integer) object.getClass().getMethod("getId").invoke(object);
					String nome = object.toString();
					
					List<?> value = value();
					if(value != null) {
						for(Object object2:value) {
							if(object == object2)
								out.println("      <option value=\""+id+"\" selected=\"selected\">"+nome);
							else
								out.println("      <option value=\""+id+"\">"+nome);
						}
					} else {
						out.println("      <option value=\""+id+"\">"+nome);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() {
		JspWriter out = pageContext.getOut();
		try {
			out.println("      </option>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	public Class<?> classe() {
		SelectTag tag = (SelectTag) findAncestorWithClass(this, SelectTag.class);
		return tag.classe();
	}
	
	public List<?> value() throws Exception {
		SelectTag tag = (SelectTag) findAncestorWithClass(this, SelectTag.class);
		return tag.value();
	}
	
	public List<?> list_values() throws Exception {
		return null;
	}
	
}
