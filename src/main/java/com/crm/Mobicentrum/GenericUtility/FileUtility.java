package com.crm.Mobicentrum.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author JOLLU KISHORE
 *@param key
 *@throws Throwable
 */
public class FileUtility implements Iconstant {
	/**
	 * This generic method is used to read the data from commondata.properties file based on key which we pass as an argument for the method
	 * @param
	 *
	 */
	public String getPropertyData(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(propertFilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;

	}


}
