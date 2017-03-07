package com.navisens.yelp;

import com.navisens.LocationServicesProtos;


public class YelpProtoBuilder {
	
	public static LocationServicesProtos.FusionResponse.YelpBody buildYelpBody(final YelpBusinessesSearchResponse resp) {
	
		LocationServicesProtos.FusionResponse.YelpBody.Builder yelpBuilder = LocationServicesProtos.FusionResponse.YelpBody.newBuilder();
		if(resp == null)
			System.out.println("this is a problem");
			
		yelpBuilder.setTotal(resp.getTotal());
		LocationServicesProtos.FusionResponse.YelpBody.Region.Builder regionBuilder = LocationServicesProtos.FusionResponse.YelpBody.Region.newBuilder();
		regionBuilder.setCenter(LocationServicesProtos.FusionResponse.YelpBody.Region.Center.newBuilder().setLatitude(resp.getRegion().getCenter().getLatitude()).setLongitude(resp.getRegion().getCenter().getLongitude()).build());
		yelpBuilder.setRegion(regionBuilder.build());
		if(resp.getError() != null)
		{
			LocationServicesProtos.FusionResponse.YelpBody.Error.Builder erroBuilder = LocationServicesProtos.FusionResponse.YelpBody.Error.newBuilder();
			erroBuilder.setCode(resp.getError().getCode());
			erroBuilder.setDescription(resp.getError().getDescription());
			yelpBuilder.setError(erroBuilder.build());
		}
		for(Business business : resp.getBusinesses())
		{
			LocationServicesProtos.FusionResponse.YelpBody.Businesses.Builder bBuilder = LocationServicesProtos.FusionResponse.YelpBody.Businesses.newBuilder();
			bBuilder.setId(business.getId());
			bBuilder.setImageUrl(business.getImage_url());
			bBuilder.setDisplayPhone(business.getDisplay_phone());
			bBuilder.setDistance(business.getDistance());
			bBuilder.setPhone(business.getPhone());
			bBuilder.setPrice(business.getPrice());
			bBuilder.setReviewCount(business.getReview_count());
			bBuilder.setIsClosed(business.isIs_closed());
			bBuilder.setUrl(business.getUrl());
			LocationServicesProtos.FusionResponse.YelpBody.Businesses.Location.Builder lBuilder = LocationServicesProtos.FusionResponse.YelpBody.Businesses.Location.newBuilder();
			if(business.getLocation().getAddress1() != null)
			lBuilder.setAddress1(business.getLocation().getAddress1());
			if(business.getLocation().getAddress2() != null)
			lBuilder.setAddress2(business.getLocation().getAddress2());
			if(business.getLocation().getAddress3() != null)
			lBuilder.setAddress3(business.getLocation().getAddress3());
			lBuilder.setState(business.getLocation().getState());
			lBuilder.setZipCode(business.getLocation().getZip_code());
			lBuilder.setCity(business.getLocation().getCity());
			lBuilder.setCountry(business.getLocation().getCountry());
			for(String display_address : business.getLocation().getDisplay_address())
			{
				lBuilder.addDisplayAddress(display_address);
			}
			bBuilder.setLocation(lBuilder.build());
			LocationServicesProtos.FusionResponse.YelpBody.Businesses.Coordinates.Builder coBuilder = LocationServicesProtos.FusionResponse.YelpBody.Businesses.Coordinates.newBuilder();
			coBuilder.setLatitude(business.getCoordinates().getLatitude());
			coBuilder.setLongitude(business.getCoordinates().getLongitude());
			bBuilder.setCoordinates(coBuilder.build());
			yelpBuilder.addBusinesses(bBuilder.build());
			
		}
		
		return yelpBuilder.build();
	}

}
