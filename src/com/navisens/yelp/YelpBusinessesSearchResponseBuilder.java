package com.navisens.yelp;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class YelpBusinessesSearchResponseBuilder {
	
	private final String yelpBussinessesSearchEndpoint = "https://api.yelp.com/v3/businesses/search";
	
	public YelpBusinessesSearchResponse getResponse(double latitude,double longitude)
	{
		try {
		HttpResponse<String> response = Unirest.get(yelpBussinessesSearchEndpoint +"?term=delis&latitude="+latitude+"&longitude=" +longitude)
				  .header("authorization", YelpAuthResponse.getInstance().getToken_type()+ " " + YelpAuthResponse.getInstance().getAccess_token())
				  .header("cache-control", "no-cache")
				  .asString();
		 if(response.getStatus() == 200)
		 {
			 Gson json = new Gson();
			 YelpBusinessesSearchResponse res = json.fromJson(response.getBody(), YelpBusinessesSearchResponse.class);
			 return res;
		 } 
		}
		catch (UnirestException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	

}
