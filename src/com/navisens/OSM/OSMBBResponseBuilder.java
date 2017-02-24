package com.navisens.OSM;

import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class OSMBBResponseBuilder {

	private final String osmBBGetEndpoint = "http://api.openstreetmap.org/api/0.6/map?bbox=";

	public OSMBBResponse getResponse(double left, double bottom, double right, double top) {
		try {

			final String path = osmBBGetEndpoint + left + "%2C" + bottom + "%2C" + right + "%2C" + top;
			HttpResponse<String> response = Unirest.get(path).header("cache-control", "no-cache").asString();

			if (response.getStatus() == 200) {
				JSONObject xmlToJson = XML.toJSONObject(response.getBody().toString());

				Gson gson = new Gson();
				OSMBBResponse resp = gson.fromJson(xmlToJson.toString(), OSMBBResponse.class);
				JSONObject obj = new JSONObject(xmlToJson.toString());
				resp.getOsm().parseWaysTags(obj.getJSONObject("osm"));
				resp.getOsm().parseRelationShipTags(obj.getJSONObject("osm"));
				return resp;
			} else {
				String error = response.getHeaders().get("Error").toString();
				OSMBBResponse osm = new OSMBBResponse();
				osm.setError(error);
				return osm;
			}
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return null;
	}

}
