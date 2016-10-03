package com.flp.ems.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class DBProps {

	private static String configFilePath = "config/dbConfig.properties";
	private static Properties dbProperties;
	
	static{
		FileInputStream fileInputStream;
		try{
			fileInputStream = new FileInputStream(configFilePath);
			dbProperties = new Properties();
			dbProperties.load(fileInputStream);
			fileInputStream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static Properties getDbProperties(){
		return (Properties)dbProperties.clone();
	}
}
