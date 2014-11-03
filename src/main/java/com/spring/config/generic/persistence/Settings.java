package com.spring.config.generic.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@SuppressWarnings("serial")
public abstract class Settings extends Properties {
	
	@SuppressWarnings("unused")
	private String read_property(String key) throws Exception {
		return load_properties().getProperty(key);
	}

	private Properties load_properties() throws Exception {
		Properties props = new Properties();
		
		File fos = new File( getFilename() );
		if(fos.exists()) {
			FileInputStream inStream = new FileInputStream( getFilename() );
			props.load(inStream);
			inStream.close();
		} else {
			FileOutputStream outStream = new FileOutputStream( getFilename() );
			for(String p:fields()) {
				props.setProperty(p, "---");
			}
			props.store(outStream, "settings");
			outStream.close();
		}
		
		return props;
	}
	
	private List<String> fields() {
		List<String> lista = new ArrayList<String>();
		
		Field fields[] = this.getClass().getDeclaredFields();
		for(int i=0; i<fields.length; i++)
			lista.add(fields[i].getName());
		
		return lista;
	}
	
	private String getFilename() {
		return System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences";
	}	
	
}
