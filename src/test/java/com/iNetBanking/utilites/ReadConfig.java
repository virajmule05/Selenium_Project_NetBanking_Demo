package com.iNetBanking.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties po;
	
    public ReadConfig() 
{
	File src=new File("./Configuration/config.properties");
	
	try {
	FileInputStream fis=new FileInputStream(src);
	
	po=new Properties();
	
	po.load(fis);
	}
	catch(Exception e)
	{
		System.out.println("Exception is"+e.getMessage());
	}
	

}

   public String getApplicationUrl()
   {
	   String url = po.getProperty("url");
	    return url;
   }
   
   public String getUsername()
   {
	   String username = po.getProperty("username");
	   return username;
	   
	   
   }
   public String getPassword()
   {
	   String password = po.getProperty("password");
	  return password;
	   
   }
   
   public String getchromepath()
   {
	   String chrome = po.getProperty("chromepath");
	return chrome;
	
   }
      public String getfirefoxpath()
      {
    	  String firefox=po.getProperty("firefoxpath");
		return firefox;
    			  
      }

}
