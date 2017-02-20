package com.navisens.yelp;

import java.util.TimerTask;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
/*
 * A scheduler class to update the access token from yelp
 */
public class YelpAuthSchedulerTask extends TimerTask {

	private static final String client_id ="FMri82WvsNmiiQhXf1rVAw";
	private static final String client_secret = "7tQ5FfUb2TA3aJZTk8Mt6nHP0wfHqqeFdXXxx7hlFJewmqKMIxUmU4cpMywJKdtx";
	private static final String grant_type = "client_credentials";
	@Override
	public void run() {
		
		if(getAuthToken())
		{
			System.out.println("Sucess! got the auth token from Yelp! ");
		}
		
	}
	
	public boolean getAuthToken()
	{
		try {
			HttpResponse<JsonNode> response = Unirest.post("https://api.yelp.com/oauth2/token")
					  .header("content-type", "application/x-www-form-urlencoded")
					  .header("cache-control", "no-cache")
					  .body("grant_type="+ grant_type +"&client_id="+client_id+"&client_secret=" + client_secret)
					  .asJson();
				 
				if(response.getStatus() == 200)
				{
					String accessToken = response.getBody().getObject().getString("access_token");
					String token_type = response.getBody().getObject().getString("token_type");
					int expiresIn = response.getBody().getObject().getInt("expires_in");
					YelpAuthResponse.getInstance().setExpires_in(expiresIn);
					YelpAuthResponse.getInstance().setToken_type(token_type);
					YelpAuthResponse.getInstance().setAccess_token(accessToken);
					return true;
				}
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
