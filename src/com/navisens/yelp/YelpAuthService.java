package com.navisens.yelp;

import java.util.Timer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


/*
  A bootstrap Servlet that initializes Yelp Auth Token and then creates a scheduler to keep it updated. 
  Yelp has a expire period of 180 days which comes in seconds.
  37.786882&longitude=-122.399972
 */
public class YelpAuthService extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		YelpAuthSchedulerTask st = new YelpAuthSchedulerTask(); 
		if(st.getAuthToken())
		{
			long expire_by = YelpAuthResponse.getInstance().getExpires_in() * 1000;
			System.out.println("Schedular created with time: " + expire_by);
			Timer time = new Timer(); 
			time.schedule(st, 0, expire_by);
		}
		else
			System.out.println("Did not get auth!");
	
	}
	
	
	
	
}
