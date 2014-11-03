package com.spring.config.generic.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class settingsService<E extends Properties> {
	
	protected Class<?> clazz;
	
	public settingsService(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public void create_properties(E props) throws Exception {
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		for(int i=0; i<fields().size(); i++) {
			props.setProperty(fields().get(i), values().get(i));
		}
		props.store(outStream, "settings");
		outStream.close();
	}
	
	public void save_properties(E props) throws Exception {
		FileInputStream inStream = new FileInputStream( getFilename() );
		Properties props_current = new Properties();
		props.load(inStream);
		for(Object key:props.entrySet()) {
			props_current.setProperty(key.toString(), props.get(key).toString());
		}
		inStream.close();
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		props_current.store(outStream, "settings");
		outStream.close();
	}
	
	public void delete_properties(E props) throws Exception {
		FileInputStream inStream = new FileInputStream( getFilename() );
		Properties props_current = new Properties();
		props_current.load(inStream);
		for(Object key:props.entrySet()) {
			props_current.remove(key);
		}
		inStream.close();
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		props_current.store(outStream, "settings");
		outStream.close();
	}
	
	private List<String> fields() throws Exception {
		List<String> lista = new ArrayList<String>();
		
		Field fields[] = clazz.newInstance().getClass().getDeclaredFields();
		for(int i=0; i<fields.length; i++)
			lista.add(fields[i].getName());
		
		return lista;
	}
	
	private List<String> values() throws Exception {
		List<String> lista = new ArrayList<String>();
		
		Method methods[] = clazz.newInstance().getClass().getDeclaredMethods();
		for(int i=0; i<methods.length; i++)
			if(methods[i].getName().substring(0, 3).equals("get"))
				lista.add(methods[i].invoke(clazz.newInstance()).toString());
		
		return lista;
	}
	
	public String getFilename() {
		return System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences";
	}
	
	public String getName() {
		return clazz.getSimpleName();
	}
	
}
