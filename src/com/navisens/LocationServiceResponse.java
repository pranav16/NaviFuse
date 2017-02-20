package com.navisens;

import com.navisens.OSM.OSMBBResponse;
import com.navisens.yelp.YelpBusinessesSearchResponse;

public class LocationServiceResponse {

	private YelpBusinessesSearchResponse Yelp;
	private OSMBBResponse OSM;
	public YelpBusinessesSearchResponse getYelp() {
		return Yelp;
	}
	public void setYelp(YelpBusinessesSearchResponse yelp) {
		Yelp = yelp;
	}
	public OSMBBResponse getOSM() {
		return OSM;
	}
	public void setOSM(OSMBBResponse oSM) {
		OSM = oSM;
	}
	@Override
	public String toString() {
		return "LocationServiceResponse [Yelp=" + Yelp + ", OSM=" + OSM + "]";
	}
	
}
