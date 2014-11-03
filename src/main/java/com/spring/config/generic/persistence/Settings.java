package com.spring.config.generic.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@SuppressWarnings("serial")
public abstract class Settings extends Properties {
	
	@SuppressWarnings("unused")
	private String read_property(String key) {
		return load_properties().getProperty(key);
	}

	private Properties load_properties() {
		Properties props = new Properties();
		
		FileInputStream fos = null;
		try {
			fos = new FileInputStream( getFilename() );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			props.load(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return props;
	}
	
	private String getFilename() {
		return System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences";
	}	
	
}
