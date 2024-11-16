package com.Dalvkot.Vims_GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * This class conatains Property file Specific comman method
 * @author Sudarshan
 *
 */

public class FileUtility {
	/**
	 * This method is used to read the data from commondata.propertie file
	 * @throws Throwable 
	 * 
	 */
	public String getProperyKeyValue(String key) throws Throwable
	{
	    FileInputStream fis=new FileInputStream("./src/main/resources/CommanData/Credentials.properties");
	    Properties pobj=new Properties();
	    pobj.load(fis);
	    String value=pobj.getProperty(key);
	    return value;
	
	}
	

}
