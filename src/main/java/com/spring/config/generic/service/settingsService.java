package com.spring.config.generic.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class settingsService<E> {
	
	protected Class<?> clazz;
	
	public settingsService(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public void create_properties(E props) throws Exception {
		Properties nova = new Properties();
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		
		Field fields[] = props.getClass().getDeclaredFields();
		Method methods[] = props.getClass().getMethods();
		int field_counter = 0;
		for(int i=0; i<methods.length; i++) {
			if(methods[i].getName().substring(0, 3).equals("get")) {
				nova.setProperty(fields[field_counter++].getName(), methods[i].invoke(props).toString());
			}
		}
		
		nova.store(outStream, "settings");
		outStream.close();
	}
	
	public void save_properties(E props) throws Exception {
		Properties current = new Properties();
		
		System.out.println("inStream");
		FileInputStream inStream = new FileInputStream( getFilename() );
		current.load(inStream);
		inStream.close();
		
		Field fields[] = props.getClass().getDeclaredFields();
		Method methods[] = props.getClass().getMethods();
		int field_counter = 0;
		for(int i=0; i<methods.length; i++) {
			if(methods[i].getName().substring(0, 3).equals("get")) {
				System.out.println(fields[field_counter].getName() + " = " + methods[i].invoke(props).toString());
				current.setProperty(fields[field_counter++].getName(), methods[i].invoke(props).toString());
			}
		}
		
		System.out.println("outStream");
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
			current.remove(fields[i].getName());
		}
		
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		current.store(outStream, "settings");
		outStream.close();
	}
	
	private String getFilename() {
		return System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences";
	}
	
}
