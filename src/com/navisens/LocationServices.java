package com.navisens;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import com.navisens.OSM.OSMBBResponse;
import com.navisens.OSM.OSMBBResponseBuilder;
import com.navisens.OSM.OSMNodeProcessor;
import com.navisens.OSM.OSMProtoBuilder;
import com.navisens.yelp.YelpBusinessesSearchResponseBuilder;
import com.navisens.yelp.YelpProtoBuilder;

@Path("/LocationServices")
public class LocationServices {

	@GET
	@Path("/fusing-service")
	@Produces("application/x-protobuf")
	public LocationServicesProtos.FusionResponse aggregator(@QueryParam("size") double size,
			@QueryParam("latitude") double latitude, @QueryParam("longitude") double longitude) {
		YelpBusinessesSearchResponseBuilder yelpBuilder = new YelpBusinessesSearchResponseBuilder();
		OSMBBResponseBuilder osmBuilder = new OSMBBResponseBuilder();
		LocationServiceResponse response = new LocationServiceResponse();
		double left = longitude - size / 2;
		double right = longitude + size / 2;
		double bottom = latitude - size / 2;
		double top = latitude + size / 2;
		OSMBBResponse osmResp = osmBuilder.getResponse(left, bottom, right, top);
		OSMNodeProcessor processor = new OSMNodeProcessor();
		response.setOSM(processor.ProcessData(osmResp));
		response.setYelp(yelpBuilder.getResponse(latitude, longitude));
		LocationServicesProtos.FusionResponse.Builder responseBuilder = LocationServicesProtos.FusionResponse
				.newBuilder();
		responseBuilder.setOSM(OSMProtoBuilder.buildOSMBody(response.getOSM()));
		responseBuilder.setYelp(YelpProtoBuilder.buildYelpBody(response.getYelp()));
		return responseBuilder.build();
	}

}
