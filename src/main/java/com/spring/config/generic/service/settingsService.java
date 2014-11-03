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
	
	public String read_property(String key) throws Exception {
		return load_properties().getProperty(key);
	}
	
	@SuppressWarnings("unchecked")
	public void save_property(String key, String value) throws Exception {
		Properties props = load_properties();
		props.setProperty(key, value);
		save_properties((E) props);
	}
	
	@SuppressWarnings("unchecked")
	public E load_properties() throws Exception {
		Properties props = new Properties();
		
		FileInputStream fos = new FileInputStream( getFilename() );
		props.load(fos);
		fos.close();
		
		return (E) props;
	}
	
	public void create_properties(E props) throws Exception {
		FileInputStream fos = new FileInputStream( getFilename() );
		Properties props_current = new Properties();
		props_current.load(fos);
		for(Object key:props.keySet()) {
			props_current.setProperty(key.toString(), props.get(key).toString());
		}
		fos.close();
		FileOutputStream out = new FileOutputStream( getFilename() );
		props_current.store(out, "settings");
		out.close();
	}
	
	public void save_properties(E props) throws Exception {
		FileInputStream fos = new FileInputStream( getFilename() );
		Properties props_current = new Properties();
		props_current.load(fos);
		for(Object key:props.keySet()) {
			props_current.setProperty(key.toString(), props.get(key).toString());
		}
		fos.close();
		FileOutputStream out = new FileOutputStream( getFilename() );
		props_current.store(out, "settings");
		out.close();
	}
	
	public void delete_properties(E props) throws Exception {
		FileInputStream fos = new FileInputStream( getFilename() );
		Properties props_current = new Properties();
		props_current.load(fos);
		for(Object key:props.keySet()) {
			props_current.remove(key);
		}
		fos.close();
		FileOutputStream out = new FileOutputStream( getFilename() );
		props_current.store(out, "settings");
		out.close();
	}
	
	public String getFilename() {
		return System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences";
	}
	
	public String getName() {
		return clazz.getSimpleName();
	}
	
}
