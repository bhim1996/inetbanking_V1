package com.inetbanking.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro;
	
	public ReadConfig() {
		
		File src=new File("./configuration/config.properties");
		
		try {
			
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		 
		
	}

}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getusername() {
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getpassword() {
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getchromepath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getfirefoxepath() {
		String firefoxpath=pro.getProperty("Firefoxpath");
		return firefoxpath;
	}
	public String getIEpath() {
		String IEpath=pro.getProperty("IEpath");
		return IEpath;
	}
	
	
	
	
	
}