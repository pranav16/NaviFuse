package com.navisens.yelp;

import java.util.ArrayList;
/*
 * Simple POJO defining the Yelp business Search Response.
 */
public class YelpBusinessesSearchResponse {

	private long total;
	private ArrayList<Business>businesses;
	private Region region;
	private Error error;
	
	@Override
	public String toString() {
		return "YelpBusinessesSearchResponse [total=" + total + ", businesses=" + businesses + ", region=" + region
				+ ", error=" + error + "]";
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public ArrayList<Business> getBusinesses() {
		return businesses;
	}
	public void setBusinesses(ArrayList<Business> businesses) {
		this.businesses = businesses;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}
	
}

class Business
{
	
	private double rating;
	private String price;
    private	String phone;
	private String display_phone;
	private long review_count;
	private String id;
	private boolean is_closed;
	private double distance;
	private String image_url;
	private String url;
	private ArrayList<Category>categories;
	private Location location;
	private Coordinates coordinates;
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDisplay_phone() {
		return display_phone;
	}
	public void setDisplay_phone(String display_phone) {
		this.display_phone = display_phone;
	}
	public long getReview_count() {
		return review_count;
	}
	public void setReview_count(long review_count) {
		this.review_count = review_count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isIs_closed() {
		return is_closed;
	}
	public void setIs_closed(boolean is_closed) {
		this.is_closed = is_closed;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ArrayList<Category> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	
}

class Category
{
	private String alias;
	private String title;
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}

class Coordinates
{
	private double longitude;
	private double latitude;
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}

class Location
{
	private String address1;
	private String state;
	private String city;
    private	String address3;
	private String address2;
	private int zip_code;
	private String country;
	private ArrayList<String>display_address;
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public ArrayList<String> getDisplay_address() {
		return display_address;
	}
	public void setDisplay_address(ArrayList<String> display_address) {
		this.display_address = display_address;
	}
}

class Region
{
	private Center center;

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}
}

class Center
{
	private double longitude;
	private double latitude;
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}

class Error
{
  private String code;
  private String description;
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "Error [code=" + code + ", description=" + description + "]";
}
}


