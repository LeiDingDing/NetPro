package yzu.shopping.util;

import yzu.shopping.dao.ICategory;
import yzu.shopping.impl.CategoryImpl;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConextListener implements ServletContextListener {

	private ICategory categoryImpl = new CategoryImpl();

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		event.getServletContext().setAttribute("categorys",categoryImpl.queryCategory(""));
		ShoppingTimerTask shoppingTimer=new ShoppingTimerTask();
		shoppingTimer.setApplication(event.getServletContext());
		new Timer().schedule(shoppingTimer,0L,1000*5);
	}
}
