package com.navisens.OSM;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class OSMBBResponse {
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
	private ArrayList<Node> node;
	private ArrayList<Ways> way;
	private ArrayList<Relation> relation;

	@Override
	public String toString() {
		return "OSM [version=" + version + ", generator=" + generator + ", copyright=" + copyright + ", attribution="
				+ attribution + ", license=" + license + ", bounds=" + bounds + ", node=" + node + ", way=" + way
				+ ", relation=" + relation + "]";
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

	public ArrayList<Relation> getRelation() {
		return relation;
	}

	public void setRelation(ArrayList<Relation> relation) {
		this.relation = relation;
	}

	public void parseWaysTags(JSONObject object) {
		JSONArray way = object.getJSONArray("way");

		for (int i = 0; i < way.length(); i++) {
			if (!way.getJSONObject(i).has("tag"))
				continue;
			Object isArray = way.getJSONObject(i).get("tag");
			ArrayList<Tags> tags = new ArrayList<Tags>();
			if (isArray instanceof JSONArray) {

				JSONArray tag = (JSONArray) isArray;
				for (int j = 0; j < tag.length(); j++) {
					JSONObject obj = tag.getJSONObject(j);
					Tags _tag = new Tags();
					_tag.setV(obj.optString("v"));
					_tag.setK(obj.optString("k"));
					tags.add(_tag);
				}
			} else if (isArray instanceof JSONObject) {
				JSONObject optTag = (JSONObject) isArray;
				if (optTag != null) {

					Tags _tag = new Tags();
					_tag.setV(optTag.optString("v"));
					_tag.setK(optTag.optString("k"));
					tags.add(_tag);
				}
			}

			this.way.get(i).setTag(tags);
		}
	}

	public void parseRelationShipTags(JSONObject object) {
		JSONArray relation = object.getJSONArray("relation");
		for (int i = 0; i < relation.length(); i++) {
			ArrayList<Tags> tags = new ArrayList<Tags>();
			if (relation.getJSONObject(i).has("tag")) {
				Object isArray = relation.getJSONObject(i).get("tag");
				if (isArray instanceof JSONArray) {
					JSONArray tag = (JSONArray) isArray;
					for (int j = 0; j < tag.length(); j++) {
						JSONObject obj = tag.getJSONObject(j);
						Tags _tag = new Tags();
						_tag.setV(obj.optString("v"));
						_tag.setK(obj.optString("k"));
						tags.add(_tag);
					}
				} else if (isArray instanceof JSONObject) {
					JSONObject opttag = relation.getJSONObject(i).getJSONObject("tag");
					if (opttag != null) {
						Tags _tag = new Tags();
						_tag.setV(opttag.optString("v"));
						_tag.setK(opttag.optString("k"));
						tags.add(_tag);
					}
				}
			}
			ArrayList<Memebers> memList = new ArrayList<Memebers>();
			if (relation.getJSONObject(i).has("member")) {
				Object isArray = relation.getJSONObject(i).get("member");
				if (isArray instanceof JSONArray) {
					JSONArray mem = relation.getJSONObject(i).getJSONArray("member");
					for (int j = 0; j < mem.length(); j++) {
						JSONObject obj = mem.getJSONObject(j);
						if (obj != null) {
							Memebers member = new Memebers();
							member.setRef(obj.optLong("ref"));
							member.setRole(obj.optString("role"));
							member.setType(obj.optString("type"));
							memList.add(member);
						}

					}
				} else if (isArray instanceof JSONObject) {
					JSONObject oMember = relation.getJSONObject(i).getJSONObject("member");
					Memebers member = new Memebers();
					member.setRef(oMember.optLong("ref"));
					member.setRole(oMember.optString("role"));
					member.setType(oMember.optString("type"));
					memList.add(member);
				}

			}
			this.relation.get(i).setMember(memList);
			this.relation.get(i).setTag(tags);
		}
	}

}

class Bounds {
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

class Node {
	private long id;
	private long changeset;
	private String timestamp;
	private int version;
	private boolean visible;
	private String user;
	private long uid;
	private double lat;
	private double lon;

	@Override
	public String toString() {
		return "Node [id=" + id + ", changeset=" + changeset + ", timestamp=" + timestamp + ", version=" + version
				+ ", visibile=" + visible + ", user=" + user + ", uid=" + uid + ", lat=" + lat + ", lon=" + lon + "]";
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
		return visible;
	}

	public void setVisibile(boolean visibile) {
		this.visible = visibile;
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

class Ways {

	private ArrayList<ND> nd;
	private long id;
	private ArrayList<Tags> wtag;
	private boolean visible;

	@Override
	public String toString() {
		return "Ways [nd=" + nd + ", id=" + id + ", wtag=" + wtag + ", isVisible=" + visible + "]";
	}

	public ArrayList<ND> getNd() {
		return nd;
	}

	public void setNd(ArrayList<ND> nd) {
		this.nd = nd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<Tags> getTag() {
		return wtag;
	}

	public void setTag(ArrayList<Tags> tag) {
		this.wtag = tag;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}

class ND {
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

class Memebers {
	private long ref;
	private String role;
	private String type;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getRef() {
		return ref;
	}

	public void setRef(long ref) {
		this.ref = ref;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

class Tags {
	private String v;
	private String k;

	@Override
	public String toString() {
		return "Tag [v=" + v + ", k=" + k + "]";
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

}

class Relation {
	private long uid;
	private long id;
	private boolean visible;
	private ArrayList<Memebers> rmember;
	private ArrayList<Tags> rtag;
	private long version;

	private String user;
	private String timestamp;
	private long changeset;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public long getChangeset() {
		return changeset;
	}

	public void setChangeset(long changeset) {
		this.changeset = changeset;
	}

	public ArrayList<Memebers> getMember() {
		return rmember;
	}

	public void setMember(ArrayList<Memebers> member) {
		this.rmember = member;
	}

	public ArrayList<Tags> getTag() {
		return rtag;
	}

	public void setTag(ArrayList<Tags> tag) {
		this.rtag = tag;
	}

}
