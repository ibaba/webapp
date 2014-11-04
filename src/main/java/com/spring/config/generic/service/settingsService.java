package com.spring.config.generic.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.Properties;

import com.spring.config.annotation.settings.Property;

public class settingsService<E> {
	
	protected Class<?> clazz;
	
	public settingsService(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public void create_properties(E props) throws Exception {
		Properties nova = new Properties();
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		
		Field fields[] = props.getClass().getDeclaredFields();
		for(int i=0; i<fields.length; i++) {
			String key = fields[i].getAnnotation(Property.class).key();
			String value = props.getClass().getMethod("get"+caps(fields[i].getName())).invoke(props).toString();
			nova.setProperty(key, value);
		}
		
		nova.store(outStream, "settings");
		outStream.close();
	}
	
	public void save_properties(E props) throws Exception {
		Properties current = new Properties();
		
		FileInputStream inStream = new FileInputStream( getFilename() );
		current.load(inStream);
		inStream.close();
		
		Field fields[] = props.getClass().getDeclaredFields();
		for(int i=0; i<fields.length; i++) {
			String key = fields[i].getAnnotation(Property.class).key();
			String value = props.getClass().getMethod("get"+caps(fields[i].getName())).invoke(props).toString();
			current.setProperty(key, value);
		}
		
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		current.store(outStream, "settings");
		outStream.close();
	}
	
	public void delete_properties(E props) throws Exception {
		Properties current = new Properties();
		
		FileInputStream inStream = new FileInputStream( getFilename() );
		current.load(inStream);
		inStream.close();
		
		Field fields[] = props.getClass().getDeclaredFields();
		for(int i=0; i<fields.length; i++) {
			current.remove(props.getClass().getSimpleName()+"."+fields[i].getName());
		}
		
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		current.store(outStream, "settings");
		outStream.close();
	}
	
	private String getFilename() {
		return System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences";
	}
	
	private String caps(String string) {
		char[] charArray = string.toCharArray();
		charArray[0] = Character.toUpperCase(charArray[0]);
		String Key = new String(charArray);
		return Key;
	}
	
}
