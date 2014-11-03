package com.spring.config.generic.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class settingsService<E extends Properties> {
	
	protected Class<?> clazz;
	
	public settingsService(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public void create_properties(E props) throws Exception {
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		props.store(outStream, "settings");
		outStream.close();
	}
	
	public void save_properties(E props) throws Exception {
		System.out.println("props ->"+props.size());
		Properties props_current = new Properties();
		
		System.out.println("inStream");
		FileInputStream inStream = new FileInputStream( getFilename() );
		props.load(inStream);
		inStream.close();
		
		for(Object key:props.entrySet()) {
			System.out.println(key.toString() + " = " + props.get(key).toString());
			props_current.setProperty(key.toString(), props.get(key).toString());
		}
		
		System.out.println("outStream");
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		props_current.store(outStream, "settings");
		outStream.close();
	}
	
	public void delete_properties(E props) throws Exception {
		System.out.println("props ->"+props.size());
		Properties props_current = new Properties();
		
		System.out.println("inStream");
		FileInputStream inStream = new FileInputStream( getFilename() );
		props_current.load(inStream);
		inStream.close();
		
		for(Object key:props.entrySet()) {
			System.out.println(key.toString() + " = " + props.get(key).toString());
			props_current.remove(key);
		}
		
		System.out.println("outStream");
		FileOutputStream outStream = new FileOutputStream( getFilename() );
		props_current.store(outStream, "settings");
		outStream.close();
	}
	
	public String getFilename() {
		return System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences";
	}
	
	public String getName() {
		return clazz.getSimpleName();
	}
	
}
