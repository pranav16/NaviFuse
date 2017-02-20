package com.navisens.OSM;

import java.util.ArrayList;

public class OSMBBResponse
{
	private OSM osm;
	private String error;

	
	public OSM getOsm() {
		return osm;
	}

	public void setOsm(OSM osm) {
		this.osm = osm;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "OSM [osm=" + osm + ", error=" + error + "]";
	}
}

 class OSM {

	private double version;
	private String generator;
	private String copyright;
	private String attribution;
	private String license;
	private Bounds bounds;
	private ArrayList<Node>node;
	private ArrayList<Ways>way;
	@Override
	public String toString() {
		return "OSMBBResponse [version=" + version + ", generator=" + generator + ", copyright=" + copyright
				+ ", attribution=" + attribution + ", license=" + license + ", bounds=" + bounds + ", nodes=" + node
				+ ", nd=" + way + "]";
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
	public String getGenerator() {
		return generator;
	}
	public void setGenerator(String generator) {
		this.generator = generator;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getAttribution() {
		return attribution;
	}
	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public Bounds getBounds() {
		return bounds;
	}
	public void setBounds(Bounds bounds) {
		this.bounds = bounds;
	}
	public ArrayList<Node> getNodes() {
		return node;
	}
	public void setNodes(ArrayList<Node> nodes) {
		this.node = nodes;
	}
	public ArrayList<Ways> getWay() {
		return way;
	}
	public void setNd(ArrayList<Ways> way) {
		this.way = way;
	}
	
	
	
}

class Bounds
{
	private double minlat;
	private double minlon;
	private double maxlat;
	private double maxlon;
	@Override
	public String toString() {
		return "Bounds [minlat=" + minlat + ", minlon=" + minlon + ", maxlat=" + maxlat + ", maxlon=" + maxlon + "]";
	}
	public double getMinlat() {
		return minlat;
	}
	public void setMinlat(double minlat) {
		this.minlat = minlat;
	}
	public double getMinlon() {
		return minlon;
	}
	public void setMinlon(double minlon) {
		this.minlon = minlon;
	}
	public double getMaxlat() {
		return maxlat;
	}
	public void setMaxlat(double maxlat) {
		this.maxlat = maxlat;
	}
	public double getMaxlon() {
		return maxlon;
	}
	public void setMaxlon(double maxlon) {
		this.maxlon = maxlon;
	}
}

class Node
{
	private long id;
	private long changeset;
	private String timestamp;
	private int version;
	private boolean visibile;
	private String user;
	private long uid;
	private double lat;
	private double lon;
	@Override
	public String toString() {
		return "Node [id=" + id + ", changeset=" + changeset + ", timestamp=" + timestamp + ", version=" + version
				+ ", visibile=" + visibile + ", user=" + user + ", uid=" + uid + ", lat=" + lat + ", lon=" + lon + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getChangeset() {
		return changeset;
	}
	public void setChangeset(long changeset) {
		this.changeset = changeset;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public boolean isVisibile() {
		return visibile;
	}
	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}

}

class Ways
{
	
	ArrayList<ND>nd;

	public ArrayList<ND> getNd() {
		return nd;
	}

	public void setNd(ArrayList<ND> nd) {
		this.nd = nd;
	}

	@Override
	public String toString() {
		return "Ways [nd=" + nd + "]";
	}
	
}

class ND
{
	private long ref;

	@Override
	public String toString() {
		return "Ways [ref=" + ref + "]";
	}

	public long getRef() {
		return ref;
	}

	public void setRef(long ref) {
		this.ref = ref;
	}
}



