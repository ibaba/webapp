package com.spring.config.generic.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class settingsService<E> {
	
	protected Class<?> clazz;
	
	public settingsService(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public void create_properties(E props) throws Exception {
		Properties nova = new Properties();
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		
		//
		
		nova.store(outStream, "settings");
		outStream.close();
	}
	
	public void save_properties(E props) throws Exception {
		System.out.println("props = "+props);
		Properties current = new Properties();
		
		System.out.println("inStream");
		FileInputStream inStream = new FileInputStream( getFilename() );
		current.load(inStream);
		inStream.close();
		
		//
		
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
			current.remove(props.getClass().getSimpleName()+"."+fields[i].getName());
		}
		
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		current.store(outStream, "settings");
		outStream.close();
	}
	
	private String getFilename() {
		return System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences";
	}
	
}
