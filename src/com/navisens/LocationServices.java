package com.navisens;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.navisens.OSM.OSMBBResponseBuilder;
import com.navisens.yelp.YelpBusinessesSearchResponseBuilder;





@Path("/LocationServices")
public class LocationServices {

	@GET 
	@Path("/fusing-service") 
	@Produces(MediaType.APPLICATION_JSON)
	public String aggregator(@QueryParam("size")double size,@QueryParam("latitude")double latitude,@QueryParam("longitude")double longitude )
	{
		YelpBusinessesSearchResponseBuilder yelpBuilder = new YelpBusinessesSearchResponseBuilder();
		OSMBBResponseBuilder osmBuilder = new OSMBBResponseBuilder();
		LocationServiceResponse response = new LocationServiceResponse();
		double halfSize = size/2;
		System.out.println(halfSize);
		double left = longitude - size/ 2;
		double right = longitude + size/2;
		double bottom = latitude - size/2;
		double top= latitude + size /2;
		System.out.println("left: " + left + "right:" +right);
		response.setOSM(osmBuilder.getResponse(left,bottom,right,top));
		response.setYelp(yelpBuilder.getResponse(latitude, longitude));
		return 	new Gson().toJson(response);
	}
	
}
