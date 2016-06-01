package cn.cua.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;



public class test implements ServletContextListener,ServletRequestListener{

	
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Date date1 = new Date();
		
		System.out.println(format.format(date1)+","+format.format((date1.getTime()-1*60*100)));
		
		
	}
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
