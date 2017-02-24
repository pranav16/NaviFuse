package com.navisens;


import com.navisens.OSM.OSMCustomResponse;
import com.navisens.yelp.YelpBusinessesSearchResponse;

public class LocationServiceResponse {

	private YelpBusinessesSearchResponse Yelp;
	private OSMCustomResponse OSM;
	public YelpBusinessesSearchResponse getYelp() {
		return Yelp;
	}
	public void setYelp(YelpBusinessesSearchResponse yelp) {
		Yelp = yelp;
	}
	public OSMCustomResponse getOSM() {
		return OSM;
	}
	public void setOSM(OSMCustomResponse oSM) {
		OSM = oSM;
	}
	@Override
	public String toString() {
		return "LocationServiceResponse [Yelp=" + Yelp + ", OSM=" + OSM + "]";
	}
	
}
