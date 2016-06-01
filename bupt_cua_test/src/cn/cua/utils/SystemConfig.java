package cn.cua.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemConfig {
	public static String getCfgValue(String p) {
		Properties prop = new Properties();
		String value=null;
		try {
			//prop.load(new FileInputStream("D:\\myeclipse10.0\\CuaWorkspace2\\bupt_cua_test\\src\\cn\\cua\\utils/config.properties")); 
			//prop.load(new FileInputStream("data\\config.properties")); 
			SystemConfig systemConfig = new SystemConfig();
			InputStream inputStream = null;
			inputStream = systemConfig.getClass().getResourceAsStream("config.properties");
			prop.load(inputStream);
			value = prop.getProperty(p);
			System.out.println(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void main(String[] args) {
		SystemConfig.getCfgValue("logurlpattern");
		SystemConfig.getCfgValue("logreqpath");
	}

}
